package com.minibank.gluharyovtelegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class GluharyovTelegramBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(GluharyovTelegramBotApplication.class, args);
	}

}
