package com.minibank.gluharyovtelegrambot.service;

import com.minibank.gluharyovtelegrambot.config.properties.RegisterAccountRequest;
import com.minibank.gluharyovtelegrambot.feignclient.RegisterFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientRegistrationService {

        // Spring will create the implementation
        // for this class
        // and will inject the bean here (proxy)
        @Autowired
        private RegisterFeignClient registerFeignClient;

    public UUID register(String name, Long userId) {
        return registerFeignClient.register(new RegisterAccountRequest(name, userId));
    }
}
