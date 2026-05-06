package org.example.blogginapi.models;

import java.util.UUID;

public record CommentDto(UUID id,String content,UUID authorid,UUID postid,int likescount) {
}
