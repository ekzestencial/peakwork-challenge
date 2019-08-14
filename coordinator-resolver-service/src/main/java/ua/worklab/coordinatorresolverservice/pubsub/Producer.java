package ua.worklab.coordinatorresolverservice.pubsub;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;

@Configuration
public class Producer {

    public static final String MY_OUTPUT_CHANNEL = "myOutputChannel";

    @Value("${pubsub.topic.name}")
    String topicName;

    @Bean
    @ServiceActivator(inputChannel = MY_OUTPUT_CHANNEL)
    public MessageHandler messageSender(PubSubTemplate pubsubTemplate) {
        return new PubSubMessageHandler(pubsubTemplate, topicName);
    }

    @MessagingGateway(defaultRequestChannel = MY_OUTPUT_CHANNEL)
    public interface PubsubOutboundGateway {
        void sendToPubsub(String info);
    }
}
