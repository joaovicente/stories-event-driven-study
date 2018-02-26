package io.github.joaovicente.stories;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

@Log
public class KafkaTopicReceiver {
    private final String authorCreatedTopic = "author-created";
    @Autowired
    AuthorRepository authorRepository;

    @KafkaListener(topics = authorCreatedTopic)
    public void receive(AuthorCreated authorCreated) {
        log.info("author-created event received: " + authorCreated.toString());
        Author author = Author.builder()
                .id(authorCreated.getId().toString())
                .email(authorCreated.getEmail())
                .name(authorCreated.getName())
                .build();
        authorRepository.insert(author);
    }
}

