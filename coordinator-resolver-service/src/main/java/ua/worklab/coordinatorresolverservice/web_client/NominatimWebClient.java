package ua.worklab.coordinatorresolverservice.web_client;

import reactor.core.publisher.Mono;
import ua.worklab.coordinatorresolverservice.data.dto.Info;

public interface NominatimWebClient {
    Mono<Info> getInfo(Double lat, Double lon);
}
