package com.enterprise.sib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.enterprise.sib.*")
@EntityScan("com.enterprise.sib.api.*")
@EnableJpaRepositories
public class EnterpriseSibApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnterpriseSibApplication.class, args);
	}

}
