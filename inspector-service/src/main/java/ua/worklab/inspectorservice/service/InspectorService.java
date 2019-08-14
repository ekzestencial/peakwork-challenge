package ua.worklab.inspectorservice.service;

import reactor.core.publisher.Flux;
import ua.worklab.inspectorservice.data.Info;

public interface InspectorService {

    Flux<Info> saveAll() throws InterruptedException;
}
