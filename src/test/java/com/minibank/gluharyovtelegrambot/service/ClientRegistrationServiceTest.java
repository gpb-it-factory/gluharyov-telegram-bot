package com.minibank.gluharyovtelegrambot.service;

import com.minibank.gluharyovtelegrambot.config.properties.RegisterAccountRequest;
import com.minibank.gluharyovtelegrambot.feignclient.RegisterFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ClientRegistrationServiceTest {

    @Autowired
    public ClientRegistrationService clientRegistrationService;

    @MockBean
    public RegisterFeignClient mockRegisterFeignClient;

    @Test
    public void testRegisterClient() {
        var userName = "Zhanna";
        var userId = 1234L;
        RegisterAccountRequest request = spy(new RegisterAccountRequest(userId, userName)) ;

        mockRegisterFeignClient.register(request);

        verify(mockRegisterFeignClient, atLeastOnce()).register(request);

    }
}
