package com.guillermodelamora.portafolioPersonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PortafolioPersonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortafolioPersonalApplication.class, args);
	}

}
