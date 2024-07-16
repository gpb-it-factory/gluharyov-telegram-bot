package com.minibank.gluharyovtelegrambot.service.comandsbot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class DefaultCommand extends AbstractCommand {
    @Override
    public String getCommand() {
        return "";
    }

    @Override
    public String execute(Update update) {
        return "Напишите: /ping";
    }
}
