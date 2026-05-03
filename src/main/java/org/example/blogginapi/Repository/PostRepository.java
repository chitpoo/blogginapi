package org.example.blogginapi.Repository;

import org.example.blogginapi.models.Post;
import org.example.blogginapi.models.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
}
