package ua.worklab.inspectorservice.service.impl;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ua.worklab.inspectorservice.consumer.DataPopulator;
import ua.worklab.inspectorservice.data.Info;
import ua.worklab.inspectorservice.repository.InspectorRepository;
import ua.worklab.inspectorservice.service.InspectorService;


@Service
public class InspectorServiceImpl implements InspectorService {

    private final InspectorRepository inspectorRepository;
    private final DataPopulator dataPopulator;

    public InspectorServiceImpl(InspectorRepository inspectorRepository, DataPopulator dataPopulator) {
        this.inspectorRepository = inspectorRepository;
        this.dataPopulator = dataPopulator;
    }

    @Override
    public Flux<Info> saveAll()  {
        final Flux<Info> information = dataPopulator.getInformation();

        return inspectorRepository.saveAll(information);
    }

}
