package io.github.joaovicente.stories.persisters;

import io.github.joaovicente.stories.events.AuthorCreatedEvent;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Log
@Component
public class AuthorPersister {
    @Autowired
    AuthorRepository authorRepository;
    public void persist(AuthorCreatedEvent event)    {
        Author author = Author.builder()
                .id(event.getId().toString())
                .email(event.getEmail())
                .name(event.getName())
                .build();
        authorRepository.insert(author);
        log.info("author-created event received: " + event.toString());
    }
}
