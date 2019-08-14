package ua.worklab.inspectorservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SchedulerService {

    private final InspectorService inspectorService;

    public SchedulerService(InspectorService inspectorService) {
        this.inspectorService = inspectorService;
    }

    //            @Override
    @Scheduled(fixedDelay = 50000)
    public void afterPropertiesSet() throws InterruptedException {
        inspectorService.saveAll();
        log.info("save to database");
    }
}
