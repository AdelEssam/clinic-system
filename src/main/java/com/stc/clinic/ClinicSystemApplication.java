package com.stc.clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.stc.clinic"})
public class ClinicSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicSystemApplication.class, args);
	}

}
