package com.minibank.gluharyovtelegrambot.service.comandsbot;

import com.minibank.gluharyovtelegrambot.service.ClientRegistrationService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class RegisterCommand extends AbstractCommand {

    private final ClientRegistrationService clientRegistrationService;

    public RegisterCommand(ClientRegistrationService clientRegistrationService) {
        this.clientRegistrationService = clientRegistrationService;
    }

    @Override
    public String getCommand() {
        return "/register";
    }

    @Override
    public String execute(Update update) {
        var userName = update.getMessage().getChat().getFirstName();
        Long userId = update.getMessage().getFrom().getId();
        clientRegistrationService.register(userId, userName);
        return "you registered";



    }
}
