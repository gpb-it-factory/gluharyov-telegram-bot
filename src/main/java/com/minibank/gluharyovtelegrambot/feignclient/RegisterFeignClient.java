package com.minibank.gluharyovtelegrambot.feignclient;

import com.minibank.gluharyovtelegrambot.config.properties.RegisterAccountRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "${feign.name}", url = "${feign.url}", path = "${feign.path}")
public interface RegisterFeignClient {

    @PostMapping()
    ResponseEntity<HttpStatus> register(RegisterAccountRequest registerAccountRequest);
}
