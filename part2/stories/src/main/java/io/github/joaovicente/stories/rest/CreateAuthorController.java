package io.github.joaovicente.stories.rest;

import io.github.joaovicente.stories.commandhandlers.CreateAuthorCommandHandler;
import io.github.joaovicente.stories.commands.CreateAuthorCommand;
import io.github.joaovicente.stories.events.AuthorCreatedEvent;
import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@Log
@RestController
public class CreateAuthorController {
    @Autowired
    CreateAuthorCommandHandler createAuthorCommandHandler;
    @RequestMapping(value = "/authors", method = RequestMethod.POST)

    public AuthorCreatedEvent createAuthor(@RequestBody CreateAuthorDto dto) {
        log.info("create-author command received: " + dto.toString());

        CreateAuthorCommand cmd = CreateAuthorCommand.builder()
                .name(dto.getName())
                .email(dto.getEmail()).build();
        AuthorCreatedEvent event = createAuthorCommandHandler.process(cmd);
        return event;
    }
}
