package tn.esprit.inscriptionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InscriptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InscriptionServiceApplication.class, args);
	}

}
