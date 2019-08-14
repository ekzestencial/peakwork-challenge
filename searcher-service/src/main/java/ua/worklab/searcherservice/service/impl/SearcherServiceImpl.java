package ua.worklab.searcherservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ua.worklab.searcherservice.data.Info;
import ua.worklab.searcherservice.repository.SearcherRepository;
import ua.worklab.searcherservice.service.SearcherService;

@Service
@AllArgsConstructor
public class SearcherServiceImpl implements SearcherService {

    private SearcherRepository searcherRepository;

    @Override
    public Flux<Info> getByCountry(String country) {
        return searcherRepository.findByDisplayName();
    }
}
