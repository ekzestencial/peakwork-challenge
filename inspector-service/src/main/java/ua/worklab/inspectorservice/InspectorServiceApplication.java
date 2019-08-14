package ua.worklab.inspectorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InspectorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InspectorServiceApplication.class, args);
	}

}
