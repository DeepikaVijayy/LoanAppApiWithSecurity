package com.cognizant.loanapp.eureka.loanappeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LoanAppEurekaDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanAppEurekaDiscoveryServerApplication.class, args);
	}

}
