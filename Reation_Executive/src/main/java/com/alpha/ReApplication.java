package com.alpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ReApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReApplication.class, args);
		System.out.println("RE Running");
	}
}
