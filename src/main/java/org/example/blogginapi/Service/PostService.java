package org.example.blogginapi.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.blogginapi.Repository.PostRepository;
import org.example.blogginapi.Repository.userRepository;
import org.example.blogginapi.Security.UserDetailServiceImp;
import org.example.blogginapi.Security.UserPrincipal;
import org.example.blogginapi.models.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final userRepository userRepository;
    private final UserDetailServiceImp userDetailServiceImp;

    public List<PostDto> getPostByUser(String username) {
        return postRepository.findByAuthor_Username(username).stream()
                .map(this::readPostDto)
                .toList();
    }
    public PostDto readPostDto(@NonNull Post post){
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor().getId()
        );
    }

    public PostDto getPostById(UUID id) {
        return postRepository.findById(id)
                .map(this::readPostDto)
                .orElseThrow(()->new RuntimeException("Post id not found"));
    }
    public String deletePostById(UUID postid, UserPrincipal user){
        Post p = postRepository.findById(postid).orElseThrow(()->new RuntimeException("Post not found"));
        boolean isauthor=p.getAuthor().getId().equals(user.getUser().getId());
        boolean isadmin=user.getUser().getRole()== Role.ADMIN;
        if(!isadmin && !isauthor){
            throw new RuntimeException("You are not allowed to delete this post");
        }
        postRepository.delete(p);
        return "Post deleted";

    }

    public PostDto CreatePost(CreatePostDto dto, String e) {
        users user=userRepository.findByusername(e)
                .orElseThrow(()->new RuntimeException("User not found"));
        Post newPost=new Post();
        newPost.setTitle(dto.title());
        newPost.setContent(dto.content());
        newPost.setAuthor(user);
        newPost.setSlug(dto.title().toLowerCase());
        postRepository.save(newPost);
        return readPostDto(newPost);
    }
}
