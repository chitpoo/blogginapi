package org.example.blogginapi.models;

import lombok.Data;

import java.util.UUID;

public record UserDto(UUID id,String username,Role role) {
    }
