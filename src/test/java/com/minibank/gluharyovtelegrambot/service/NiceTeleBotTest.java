package com.minibank.gluharyovtelegrambot.service;

import com.minibank.gluharyovtelegrambot.config.properties.BotProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest
class NiceTeleBotTest {

    @Autowired
    private NiceTeleBot bot;

    @MockBean
    public BotProperties mockBotProperties;

    @Test
    public void getBotUsernameTest() {
        var name = "botTestName";

        // when
        when(mockBotProperties.name()).thenReturn(name);
        var actual = bot.getBotUsername();

        // then
        assertThat(actual).isEqualTo(name);

    }
    @Test
    public void getBotTokenTest() {
        var token = "botTestToken";

        when(mockBotProperties.token()).thenReturn(token);
        var actual =  bot.getBotToken();

        assertThat(actual).isEqualTo(token);
    }

}