package io.github.joaovicente.stories.commands;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAuthorCommand {
    private String name;
    private String email;
}