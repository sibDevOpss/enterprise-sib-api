package com.enterprise.sib.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.enterprise.sib.api.endpoints","com.enterprise.sib.swagger"})
public class EnterpriseSibApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnterpriseSibApplication.class, args);
	}

}
