package com.minibank.gluharyovtelegrambot.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommandRoutingService {

    private final ClientRegistrationService clientRegistrationService;

    public SendMessage messageReceiver(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            var text = update.getMessage().getText();
            var chatId = update.getMessage().getChatId();
            var name = update.getMessage().getChat().getFirstName();
            Long userId = update.getMessage().getFrom().getId();

            // todo: UUID example:
            // UUID newId = UUID.randomUUID();

            String responseMessage;
            switch (text){
                case "/ping" -> responseMessage = "pong";
                case "/registration" -> {
                    responseMessage = "you registered";
                    clientRegistrationService.register(name, userId) ;
                }
                default -> responseMessage = "Напишите: /ping";
            }

            var message = new SendMessage();
            message.setChatId(chatId);
            message.setText(responseMessage);
            return message;
        } else {
            var message = new SendMessage();
            message.setText("Попробуйте команду: /ping");
            return message;
        }
        }
    }


