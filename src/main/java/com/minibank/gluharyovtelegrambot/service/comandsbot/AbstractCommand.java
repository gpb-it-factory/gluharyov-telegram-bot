package com.minibank.gluharyovtelegrambot.service.comandsbot;

import com.minibank.gluharyovtelegrambot.service.CommandLibrary;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;


public abstract class AbstractCommand {

    @Autowired
    private CommandLibrary library;

    @PostConstruct
    private void init() {
        library.register(this);
    }

    public abstract String getCommand();

    public abstract String execute(Update update);
}
