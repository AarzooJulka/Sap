package com.sap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.sap")
@SpringBootApplication
public class HiringDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiringDashboardApplication.class, args);
	}

}
