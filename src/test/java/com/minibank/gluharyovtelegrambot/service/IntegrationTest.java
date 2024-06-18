package com.minibank.gluharyovtelegrambot.service;


import com.minibank.gluharyovtelegrambot.config.properties.RegisterAccountRequest;
import com.minibank.gluharyovtelegrambot.feignclient.RegisterFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
public class IntegrationTest {

    @Autowired
    public CommandRoutingService routingService;

    @MockBean
    public RegisterFeignClient mockRegisterFeignClient;

    @Test
    public void testPingCommand() {
        // given
        var cmd = "/ping";
        var expectedResponse = "pong";

        Update update = createUpdateTemplate(cmd);

        // when
        var actual = routingService.messageReceiver(update);

        // then
        assertThat(actual.getText()).isEqualTo(expectedResponse);
    }

    @Test
    public void testRegisterCommand() {
        // given
        var name = "max";
        var userId = 1234L;
        String expectedResponse = "you registered";
        UUID uuid = UUID.randomUUID();

        Update update = createUpdateTemplate("/registration");
        update.getMessage().getChat().setFirstName(name);

        RegisterAccountRequest request = new RegisterAccountRequest(name, userId);
        when(mockRegisterFeignClient.register(request)).thenReturn(uuid);

        var actual = routingService.messageReceiver(update);

        // when
        assertThat(actual.getText()).isEqualTo(expectedResponse);
    }

    private static Update createUpdateTemplate(String cmd) {
        Chat chat = new Chat();
        chat.setId(123L);

        User from = new User();
        from.setId(-1234L);

        Message message = new Message();
        message.setText(cmd);
        message.setChat(chat);
        message.setFrom(from);

        Update update = new Update();
        update.setMessage(message);

        return update;
    }

}
