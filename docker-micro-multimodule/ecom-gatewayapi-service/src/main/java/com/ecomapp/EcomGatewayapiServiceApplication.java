package com.ecomapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

public class EcomGatewayapiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomGatewayapiServiceApplication.class, args);
	}

}
