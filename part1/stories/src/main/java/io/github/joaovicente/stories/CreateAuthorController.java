package io.github.joaovicente.stories;

import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@Log
@RestController
public class CreateAuthorController {
    @Autowired
    private KafkaTopicSender sender;
    private final String authorCreatedTopic = "author-created";

    @RequestMapping(value = "/authors", method = RequestMethod.POST)

    public AuthorCreated createAuthor(@RequestBody CreateAuthorDto dto) {
        log.info("create-author command received: " + dto.toString());
        AuthorCreated authorCreated = AuthorCreated.builder()
                .name(dto.getName())
                .email(dto.getEmail()).build();

        sender.send(authorCreatedTopic, ((Object) authorCreated));
        log.info("author-created event transmitted: " + authorCreated.toString());
        return authorCreated;
    }
}
