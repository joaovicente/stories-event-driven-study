package io.github.joaovicente.stories.rest;

import io.github.joaovicente.stories.persisters.Author;
import io.github.joaovicente.stories.persisters.AuthorRepository;
import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log
@RestController
public class AuthorQueryController {
    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(value = "/authors/{authorId}", method = RequestMethod.GET)
    public Author createAuthor(@PathVariable String authorId) {
        log.info("author query by id : " + authorId);
        Author author = authorRepository.findOne(authorId);
        return author;
    }
}
