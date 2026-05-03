package org.example.blogginapi.Security;

import lombok.Data;
import lombok.Getter;
import org.example.blogginapi.models.Role;

import java.util.UUID;

public record UserAuthDto(String username, String password, String email) {
}
