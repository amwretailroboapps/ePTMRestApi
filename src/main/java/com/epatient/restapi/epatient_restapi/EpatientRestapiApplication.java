package com.epatient.restapi.epatient_restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EpatientRestapiApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(EpatientRestapiApplication.class, args);
	}

}
