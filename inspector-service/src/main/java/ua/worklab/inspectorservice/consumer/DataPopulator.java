package ua.worklab.inspectorservice.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gcp.pubsub.support.GcpPubSubHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;
import reactor.core.publisher.Flux;
import ua.worklab.inspectorservice.data.Info;
import ua.worklab.inspectorservice.repository.InspectorRepository;

import java.io.IOException;

@Configuration
@Slf4j
@Getter
public class DataPopulator {
    private ObjectMapper objectMapper;
    private Flux<Info> information = Flux.just();
    InspectorRepository inspectorRepository;

    public DataPopulator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean
    @ServiceActivator(inputChannel = ConsumerConfig.PUBSUB_INPUT_CHANNEL)
    public MessageHandler messageReceiver() {
        return message -> {
            String data;
            data = new String((byte[]) message.getPayload());
            try {
                Info info = objectMapper.readValue(data, Info.class);
                System.out.println(info);

                information.mergeWith(Flux.just(info))
                        .subscribe();

            } catch (IOException e) {
                e.printStackTrace();
            }
            log.info("Message arrived! Payload: " + data);

            AckReplyConsumer consumer =
                    (AckReplyConsumer) message.getHeaders().get(GcpPubSubHeaders.ACKNOWLEDGEMENT);
            consumer.ack();
        };
    }

}
