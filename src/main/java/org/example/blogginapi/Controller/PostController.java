package org.example.blogginapi.Controller;

import lombok.RequiredArgsConstructor;
import org.example.blogginapi.Security.UserPrincipal;
import org.example.blogginapi.Service.PostService;
import org.example.blogginapi.models.CreatePostDto;
import org.example.blogginapi.models.PostDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/api/posts/{id}")
    public String deletePostById(@PathVariable UUID id, @AuthenticationPrincipal UserPrincipal user){return postService.deletePostById(id,user);}
    @PostMapping("/api/posts/")
    public PostDto CreatePost(@RequestBody CreatePostDto dto,UserPrincipal user){String e=user.getUsername();return postService.CreatePost(dto,e);}
    @PostMapping("/api/posts/id/{id}/like")
    private PostDto LikePost(@PathVariable UUID id,@AuthenticationPrincipal UserPrincipal user){return postService.LikePost(id,user);}
    @PutMapping("/api/posts/{id}")
    private PostDto UpdatePost(@PathVariable UUID postid,
                               @RequestBody  CreatePostDto dto,
                               @AuthenticationPrincipal UserPrincipal user)
    {
        return postService.UpdatePost(postid,dto,user);
    }
}
