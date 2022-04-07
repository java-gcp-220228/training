package com.revature.candyshopapieurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CandyShopApiEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandyShopApiEurekaServiceApplication.class, args);
	}

}
