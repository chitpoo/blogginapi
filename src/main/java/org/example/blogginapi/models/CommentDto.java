package org.example.blogginapi.models;

import java.util.UUID;

public record CommentDto(UUID id,String content,UserDto user,UUID postid) {
}
