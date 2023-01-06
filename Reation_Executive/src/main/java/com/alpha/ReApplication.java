package com.alpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer1Application.class, args);
		System.out.println("RE Running");
	}

}
