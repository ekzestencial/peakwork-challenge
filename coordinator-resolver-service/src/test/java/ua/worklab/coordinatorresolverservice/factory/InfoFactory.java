package ua.worklab.coordinatorresolverservice.factory;

import ua.worklab.coordinatorresolverservice.data.dto.Info;

import java.util.UUID;

import static ua.worklab.coordinatorresolverservice.api.CoordinatorResolverControllerImplTest.COORDINATE_LAT;
import static ua.worklab.coordinatorresolverservice.api.CoordinatorResolverControllerImplTest.COORDINATE_LON;
import static ua.worklab.coordinatorresolverservice.api.CoordinatorResolverControllerImplTest.COUNTRY;


public class InfoFactory {

        public static Info create() {
        return Info.builder().display_name(COUNTRY)
                .lat(COORDINATE_LAT)
                .lon(COORDINATE_LON)
                .id(UUID.randomUUID())
                .type("nde")
                .osm_type("type")
                .osm_id(543.43)
                .build();
    }
}
