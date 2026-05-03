package org.example.blogginapi.Repository;

import org.example.blogginapi.models.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface userRepository extends JpaRepository<users, UUID> {
    Optional<users> findByusername(String username);
}
