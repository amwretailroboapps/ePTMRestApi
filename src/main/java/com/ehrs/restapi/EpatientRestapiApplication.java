package com.ehrs.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
public class EpatientRestapiApplication {
//extends SpringBootServletInitializer
//	@GetMapping("/welcome")
//	public String welcomeMessage()
//	{
//		return "Welcome to Electronic Health Record System !";
//	}
//	
//	@Override
//	public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(EpatientRestapiApplication.class);
//    }
	
	public static void main(String[] args) {
		//main class to run
		SpringApplication.run(EpatientRestapiApplication.class, args);
	}

}
