package ua.worklab.coordinatorresolverservice.api.impl;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ua.worklab.coordinatorresolverservice.api.CoordinatorResolverController;
import ua.worklab.coordinatorresolverservice.service.CoordinatorResolverService;

@RestController
@AllArgsConstructor
public class CoordinatorResolverControllerImpl implements CoordinatorResolverController {

    private final CoordinatorResolverService coordinatorResolverServiceImpl;

    @Override
    public Mono<?> get(Double lat, Double lon) throws Exception {
        return coordinatorResolverServiceImpl.get(lat,lon);
    }
}
