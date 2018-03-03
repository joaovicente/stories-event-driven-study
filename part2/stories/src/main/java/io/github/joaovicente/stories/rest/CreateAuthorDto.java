package io.github.joaovicente.stories.rest;

import lombok.Data;

@Data
public class CreateAuthorDto {
    private String name;
    private String email;
}
