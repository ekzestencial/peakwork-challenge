package ua.worklab.coordinatorresolverservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdditionalConfiguration {
    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper();
    }
}
