package com.minibank.gluharyovtelegrambot.feignclient;

import com.minibank.gluharyovtelegrambot.config.properties.RegisterAccountRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@FeignClient(name = "register-service", url = "http://localhost:8080", path = "/users")
public interface RegisterFeignClient {

    @PostMapping()
    UUID register(RegisterAccountRequest registerAccountRequest);
}
