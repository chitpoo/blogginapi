package org.example.blogginapi.Repository;

import org.example.blogginapi.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;
public interface LikeRepository extends JpaRepository<Like, UUID> {
    Optional<Like> findByUser_IdAndPost_Id(UUID userId, UUID postId);
    Optional<Like> findByUser_IdAndComment_Id(UUID userId, UUID commentId);
}
