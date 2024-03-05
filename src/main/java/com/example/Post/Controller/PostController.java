package com.example.Post.Controller;

import com.example.Post.Response.PostResponse;
import com.example.Post.dto.PostDTO;
import com.example.Post.model.Post;
import com.example.Post.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("")
    public ResponseEntity <?> getPost() {
        return ResponseEntity.ok().body("Get Post successfully");
    }

    @PostMapping()
    public ResponseEntity <?> createPost(
            @RequestBody PostDTO postDTO
    ) {
        PostResponse post = postService.createPost(postDTO);
        return ResponseEntity.ok().body(post);
    }
}
