package com.minibank.gluharyovtelegrambot.service;

import com.minibank.gluharyovtelegrambot.config.properties.BotProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
@RequiredArgsConstructor
public class NiceTeleBot extends TelegramLongPollingBot {

    private final BotProperties botProperties;
    private final CommandRoutingService commandRoutingService;

    @Override
    public String getBotUsername() {

         return botProperties.name();

    }

    @Override
    public String getBotToken() {

        return botProperties.token();
    }

    @Override
    public void onUpdateReceived(Update update) {

        try {
            SendMessage sendMessage = commandRoutingService.messageReceiver(update);
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }
}
