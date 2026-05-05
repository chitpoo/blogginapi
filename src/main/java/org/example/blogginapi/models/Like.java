package org.example.blogginapi.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "likes",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id","post_id"}),
        @UniqueConstraint(columnNames = {"user_id","comment_id"})
})
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private users user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id",nullable = true)
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="comment_id",nullable = true)
    private Comment comment;
}
