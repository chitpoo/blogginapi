package org.example.blogginapi.Repository;

import org.example.blogginapi.models.Comment;
import org.example.blogginapi.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findBypost(Post post);
}
