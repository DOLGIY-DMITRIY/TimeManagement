package com.application.tm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.UUID;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TmApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmApplication.class, args);
	}

}
