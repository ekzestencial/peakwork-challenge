package ua.worklab.searcherservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import ua.worklab.searcherservice.data.Info;


@RequestMapping("/searcher")
public interface SearcherController {

    @GetMapping({"/{country}"})
    Flux<Info> getByCountry(@PathVariable("country") String country);

}
