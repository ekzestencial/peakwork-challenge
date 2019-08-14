package ua.worklab.coordinatorresolverservice.web_client.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ua.worklab.coordinatorresolverservice.data.dto.Info;
import ua.worklab.coordinatorresolverservice.web_client.NominatimWebClient;

@Component
public class NominatimWebClientImpl implements NominatimWebClient {

    private static final String URI = "/reverse?format=jsonv2";

    private final WebClient webClient;

    public NominatimWebClientImpl(@Value("${service.nominatim.url}") String serverUrl) {
        this.webClient = WebClient.builder().baseUrl(serverUrl).build();

    }

    @Override
    public Mono<Info> getInfo(Double lat, Double lon) {
        final String format = String.format("%s&lat=%f&lon=%f", URI, lat, lon);
        return webClient.get().uri(format).retrieve()
                .bodyToMono(Info.class);
    }
}
