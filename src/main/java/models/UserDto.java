package models;

import java.util.UUID;

public record UserDto(UUID id,String username,Role role) {
    }
