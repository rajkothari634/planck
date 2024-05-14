package com.lifegadget.planck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PlanckApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanckApplication.class, args);
	}

}
