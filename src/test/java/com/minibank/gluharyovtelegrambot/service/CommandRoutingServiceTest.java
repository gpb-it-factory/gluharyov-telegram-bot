package com.minibank.gluharyovtelegrambot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CommandRoutingServiceTest {

    @Autowired
    public CommandRoutingService routingService;

    @MockBean
    public ClientRegistrationService mockRegistrationSvc;

    @Test
    public void testPingCommand() {
        // given
        var cmd = "/ping";
        var expectedResponse = "pong";

        Update update = createUpdateForCommand(cmd);

        // when
        var actual = routingService.messageReceiver(update);

        // then
        assertThat(actual.getText()).isEqualTo(expectedResponse);
    }


    private static Update createUpdateForCommand(String cmd) {
        return createUpdateForCommand(cmd, "abc");
    }

    private static Update createUpdateForCommand(String cmd, String acctName) {
        Chat chat = new Chat();
        chat.setId(123L);
        chat.setFirstName(acctName);

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
