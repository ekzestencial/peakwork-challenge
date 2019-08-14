package ua.worklab.coordinatorresolverservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

@RequestMapping("/reverse")
public interface CoordinatorResolverController {
    @GetMapping("")
    Mono<?> get(@RequestParam(value="lat", required=true) Double lat,
                @RequestParam(value="lon", required=true) Double lon) throws Exception;
}
