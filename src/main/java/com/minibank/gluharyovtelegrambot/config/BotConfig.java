package com.minibank.gluharyovtelegrambot.config;

import com.minibank.gluharyovtelegrambot.service.NiceTeleBot;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BotConfig {

    private final NiceTeleBot niceTeleBot;

    @EventListener(ContextRefreshedEvent.class)
    public void init(){

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(niceTeleBot);
        } catch (TelegramApiException e) {
           // e.printStackTrace();
            log.error("Не создался бот" + e.getMessage());

        }
    }
}
