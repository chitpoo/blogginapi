package org.example.blogginapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String content;
    private String slug;
    @Enumerated(EnumType.STRING)
    private PostStatus status=PostStatus.DRAFT;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    private users author;
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> comments;
}
