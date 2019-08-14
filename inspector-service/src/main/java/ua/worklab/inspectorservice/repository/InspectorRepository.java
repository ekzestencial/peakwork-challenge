package ua.worklab.inspectorservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ua.worklab.inspectorservice.data.Info;

import java.util.UUID;

public interface InspectorRepository extends ReactiveCrudRepository<Info, UUID> {
}
