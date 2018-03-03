package io.github.joaovicente.stories.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorCreatedEvent {
    private final UUID id = UUID.randomUUID();
    private String name;
    private String email;
}

