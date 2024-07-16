package com.minibank.gluharyovtelegrambot.service.comandsbot;


import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class PingCommand extends AbstractCommand {

    @Override
    public String getCommand() {
        return "/ping";
    }

    @Override
    public String execute(Update update) {
        return "pong";
    }
}
