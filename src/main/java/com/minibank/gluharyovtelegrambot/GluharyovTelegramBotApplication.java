package com.minibank.gluharyovtelegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@ConfigurationPropertiesScan
@SpringBootApplication
@EnableFeignClients
public class GluharyovTelegramBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(GluharyovTelegramBotApplication.class, args);
	}

}
