package com.paas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.paas.app.config.CloudFoundryConfig;

@SpringBootApplication
public class PaasCloudApp {

	@Autowired
	CloudFoundryConfig cloudFoundryConfig;

	public static void main(String[] args) {
		SpringApplication.run(PaasCloudApp.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			this.start();
		};
	}

	public void start() {
		cloudFoundryConfig.generatePassReportFromCloudFoundry();
	}
}
