package org.example.blogginapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true,nullable = false)
    private String email;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDateTime creationtime;
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    List<Post> posts=new ArrayList<>();
    @OneToMany(mappedBy = "author", fetch=FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    List<Comment> comments=new ArrayList<>();
}
