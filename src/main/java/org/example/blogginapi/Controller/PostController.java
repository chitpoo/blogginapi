package org.example.blogginapi.Controller;

import lombok.RequiredArgsConstructor;
import org.example.blogginapi.Repository.PostRepository;
import org.example.blogginapi.Security.UserDetailServiceImp;
import org.example.blogginapi.Security.UserPrincipal;
import org.example.blogginapi.Service.PostService;
import org.example.blogginapi.models.PostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping("/api/posts/user/{username}")
    public List<PostDto> getPostByUser(@PathVariable String username){
        return postService.getPostByUser(username);
    }
    @GetMapping("/api/posts/id/{id}")
    public PostDto getPostById(@PathVariable UUID id){
        return postService.getPostById(id);
    }
    @DeleteMapping("/{id}")
    public String deletePostById(@PathVariable UUID id, @AuthenticationPrincipal UserPrincipal user){
        return postService.deletePostById(id,user);
    }
}
