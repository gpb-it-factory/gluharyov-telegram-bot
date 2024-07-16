package com.minibank.gluharyovtelegrambot.service;

import com.minibank.gluharyovtelegrambot.service.comandsbot.AbstractCommand;
import com.minibank.gluharyovtelegrambot.service.comandsbot.DefaultCommand;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommandLibrary {

    Map<String, AbstractCommand> commands = new HashMap<>();

    private DefaultCommand defaultCommand = new DefaultCommand();


    public void register(AbstractCommand abstractCommand) {
        if (abstractCommand.getCommand().isBlank()) return;

        commands.put(abstractCommand.getCommand(), abstractCommand);
    }

    public AbstractCommand getCommand(String command) {
        return commands.getOrDefault(command, defaultCommand);
    }
}
