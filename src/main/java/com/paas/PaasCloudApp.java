package com.paas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.paas.app.config.CloudFoundryConfig;

@ComponentScan(basePackages = { "com.paas.app" })
@SpringBootApplication
public class PaasCloudApp implements CommandLineRunner {

	@Autowired
	CloudFoundryConfig cloudFoundryConfig;

	private static Logger LOG = LoggerFactory.getLogger(PaasCloudApp.class);

	public static void main(String[] args) {
		LOG.info("STARTING : Spring boot application starting");
		SpringApplication.run(PaasCloudApp.class, args);
		LOG.info("STOPPED  : Spring boot application stopped");
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("EXECUTING : command line runner");
		cloudFoundryConfig.generatePassReportFromCloudFoundry();
	}

}