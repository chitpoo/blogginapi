package org.example.blogginapi.models;

import java.util.UUID;

public record PostDto(UUID id,String title,String content,UUID authorid) {
}
