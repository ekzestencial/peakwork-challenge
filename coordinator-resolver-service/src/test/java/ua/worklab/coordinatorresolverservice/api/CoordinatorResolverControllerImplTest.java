package ua.worklab.coordinatorresolverservice.api;

import org.junit.Ignore;
import org.junit.Test;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;
import reactor.core.publisher.Mono;
import ua.worklab.coordinatorresolverservice.AbstractIntegrationTest;
import ua.worklab.coordinatorresolverservice.data.dto.Info;
import ua.worklab.coordinatorresolverservice.factory.InfoFactory;
import ua.worklab.coordinatorresolverservice.web_client.NominatimWebClient;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CoordinatorResolverControllerImplTest extends AbstractIntegrationTest {

    public static final Double COORDINATE_LON = 4432.332;
    public static final String COUNTRY = "Ukraine";
    public static final Double COORDINATE_LAT = 443.3;
    private static final String URI = "/reverse";

    @MockBean
    private NominatimWebClient nominatimWebClient;

    @Test
    @Ignore
    public void givenRequestWithParams_whenGet_thenOk() throws Exception {

        Info info = InfoFactory.create();

        when(nominatimWebClient.getInfo(COORDINATE_LAT, COORDINATE_LON))
                .thenReturn(Mono.just(info));
        MvcResult result = this.mvc.perform(
                get(URI+"/"+COORDINATE_LAT+"/"+COORDINATE_LON)
        ).andExpect(request().asyncStarted())
                .andExpect(status().isOk())
                .andReturn();
    }

}