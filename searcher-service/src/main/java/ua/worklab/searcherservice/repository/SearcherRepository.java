package ua.worklab.searcherservice.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import ua.worklab.searcherservice.data.Info;

import java.util.UUID;

public interface SearcherRepository extends ReactiveCrudRepository<Info, UUID> {
    Flux<Info> findByDisplayName();
}
