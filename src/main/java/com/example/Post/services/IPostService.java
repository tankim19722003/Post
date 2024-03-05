package com.example.Post.services;

import com.example.Post.Response.PostResponse;
import com.example.Post.dto.PostDTO;
import com.example.Post.model.Post;

public interface IPostService {
    Post getPostById(int postId);
    PostResponse createPost(PostDTO postDTO);
    Post updatePost(PostDTO postDTO);

    Post detelePost(int postId);
}
