package ua.worklab.coordinatorresolverservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ua.worklab.coordinatorresolverservice.data.dto.Info;
import ua.worklab.coordinatorresolverservice.pubsub.Producer;
import ua.worklab.coordinatorresolverservice.service.CoordinatorResolverService;
import ua.worklab.coordinatorresolverservice.web_client.NominatimWebClient;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class CoordinatorResolverServiceImpl implements CoordinatorResolverService {

    private final NominatimWebClient nominatimWebClient;
    private final Producer.PubsubOutboundGateway producer;
    private final ObjectMapper objectMapper;


    @Override
    public Mono<Info> get(Double lat, Double lon)  {
        Mono<Info> info = nominatimWebClient.getInfo(lat, lon);
        info.subscribe(i -> {
            try {
                i.setId(UUID.randomUUID());
                String data = objectMapper.writeValueAsString(i);
                producer.sendToPubsub(data);
                log.info("Send Data " + data);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }, null, null);
        return info;
    }

}
