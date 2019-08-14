package ua.worklab.searcherservice.service;

import reactor.core.publisher.Flux;
import ua.worklab.searcherservice.data.Info;

public interface SearcherService {
    Flux<Info> getByCountry(String country);
}
