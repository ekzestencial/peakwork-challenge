package ua.worklab.coordinatorresolverservice.service;

import reactor.core.publisher.Mono;
import ua.worklab.coordinatorresolverservice.data.dto.Info;

public interface CoordinatorResolverService {
    Mono<Info> get(Double lat, Double lon) throws Exception;
}
