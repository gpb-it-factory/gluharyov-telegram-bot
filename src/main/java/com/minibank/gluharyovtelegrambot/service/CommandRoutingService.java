package com.minibank.gluharyovtelegrambot.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class CommandRoutingService {

    private final ClientRegistrationService clientRegistrationService;
    private final CommandLibrary commandLibrary;

    public SendMessage messageReceiver(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            var text = update.getMessage().getText();
            var chatId = update.getMessage().getChatId();

            String responseMessage;

            var command = commandLibrary.getCommand(text);
            responseMessage = command.execute(update);

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


