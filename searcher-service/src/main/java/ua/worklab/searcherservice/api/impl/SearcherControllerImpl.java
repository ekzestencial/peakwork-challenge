package ua.worklab.searcherservice.api.impl;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ua.worklab.searcherservice.api.SearcherController;
import ua.worklab.searcherservice.data.Info;
import ua.worklab.searcherservice.service.SearcherService;

@RestController
@AllArgsConstructor
public class SearcherControllerImpl implements SearcherController {

    private final SearcherService searcherService;


    @Override
    public Flux<Info> getByCountry(String country) {
        System.out.println(country);
        return searcherService.getByCountry(country);
    }
}
