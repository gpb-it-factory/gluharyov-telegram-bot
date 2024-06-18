package com.minibank.gluharyovtelegrambot.service;

import com.minibank.gluharyovtelegrambot.config.properties.RegisterAccountRequest;
import com.minibank.gluharyovtelegrambot.feignclient.RegisterFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClientRegistrationServiceTest {

    @Autowired
    public ClientRegistrationService clientRegistrationService;

    @MockBean
    public RegisterFeignClient mockRegisterFeignClient;

    @Test
    public void testRegisterClient() {
        var name = "Zhanna";
        UUID uuid = UUID.randomUUID();
        var userId = 1234L;
        RegisterAccountRequest request = new RegisterAccountRequest(name, userId);
        when(mockRegisterFeignClient.register(request)).thenReturn(uuid);

        var actual = clientRegistrationService.register(name, userId);

        assertThat(actual).isEqualTo(uuid);
    }
}
