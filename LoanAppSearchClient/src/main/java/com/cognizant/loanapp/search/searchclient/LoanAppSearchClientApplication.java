package com.cognizant.loanapp.search.searchclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages = "com.cognizant.loanapp.search.searchclient.repository")
public class LoanAppSearchClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanAppSearchClientApplication.class, args);
	}

}
