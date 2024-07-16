package com.minibank.gluharyovtelegrambot.service;

import com.minibank.gluharyovtelegrambot.config.properties.RegisterAccountRequest;
import com.minibank.gluharyovtelegrambot.feignclient.RegisterFeignClient;
import org.springframework.stereotype.Service;

@Service
public class ClientRegistrationService {

    private RegisterFeignClient registerFeignClient;

    public ClientRegistrationService(RegisterFeignClient registerFeignClient) {
        this.registerFeignClient = registerFeignClient;
    }

    public void register(Long userId, String userName) {
        registerFeignClient.register(new RegisterAccountRequest(userId, userName));
    }

}
