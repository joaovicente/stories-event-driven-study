package io.github.joaovicente.stories.kafka;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import io.github.joaovicente.stories.events.AuthorCreatedEvent;
import io.github.joaovicente.stories.persisters.AuthorPersister;

@Log
public class KafkaTopicReceiver {
    @Autowired
    private AuthorPersister authorPersister;
    private final String authorCreatedTopic = "author-created";

    @KafkaListener(topics = authorCreatedTopic)
    public void receive(AuthorCreatedEvent authorCreated) {
        authorPersister.persist(authorCreated);
    }
}

