package io.github.joaovicente.stories.commandhandlers;

import io.github.joaovicente.stories.commands.CreateAuthorCommand;
import io.github.joaovicente.stories.events.AuthorCreatedEvent;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.joaovicente.stories.kafka.KafkaTopicSender;
import org.springframework.stereotype.Component;

@Log
@Component
public class CreateAuthorCommandHandler {
    @Autowired
    private KafkaTopicSender sender = new KafkaTopicSender();
    private final String authorCreatedTopic = "author-created";

    public AuthorCreatedEvent process(CreateAuthorCommand cmd) {
        AuthorCreatedEvent authorCreated = AuthorCreatedEvent.builder()
                .name(cmd.getName())
                .email(cmd.getEmail()).build();
        // Let the event flow to wherever it is needed
        sender.send(authorCreatedTopic, ((Object) authorCreated));
//        log.info("author-created event transmitted: " + authorCreated.toString());
        return authorCreated;
    }
}
