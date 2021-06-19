package com.vs.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class VsDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(VsDiscoveryApplication.class, args);
	}

}
