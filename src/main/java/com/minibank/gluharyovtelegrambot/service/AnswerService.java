package com.minibank.gluharyovtelegrambot.service;


import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class AnswerService {

    public SendMessage messageReceiver(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            var text = update.getMessage().getText();
            var chatId = update.getMessage().getChatId();
            var name = update.getMessage().getChat().getFirstName();

            String responseMessage;
            switch (text){
                case "/ping" -> responseMessage = "pong";
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


