package com.example.Post.services;

import com.example.Post.Response.ParagraphResponse;
import com.example.Post.Response.PartResponse;
import com.example.Post.Response.PostResponse;
import com.example.Post.repositories.ParagraphRepository;
import com.example.Post.repositories.PartRepository;
import com.example.Post.repositories.PostRepository;
import com.example.Post.services.IPostService;
import com.example.Post.dto.PartDTO;
import com.example.Post.dto.PostDTO;
import com.example.Post.model.Paragraph;
import com.example.Post.model.Part;
import com.example.Post.model.Post;
import com.example.Post.dto.paragraphDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    private final PostRepository postRepository;
    private final ParagraphRepository paragraphRepository;
    private final PartRepository partRepository;
    @Override
    public Post getPostById(int postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new NullPointerException("Post doesn't exist")
        );
        return post;
    }

    @Override
    public PostResponse createPost(PostDTO postDTO) {
        Post post = Post.builder()
                .author(postDTO.getAuthor())
                .thumbnail(postDTO.getThumbnail())
                .title(postDTO.getTitle())
                .updateAt(new Date(System.currentTimeMillis()))
                .createdAt(new Date(System.currentTimeMillis()))
                .build();
        postRepository.save(post);

        List <Part> parts = new ArrayList<>();
        for (PartDTO partDTO : postDTO.getPartList()) {
            Part part = Part.builder()
                    .urlImage(partDTO.getUrlImage())
                    .partName(partDTO.getPartName())
                    .post(post)
                    .build();
            partRepository.save(part);
            List<Paragraph> paras = new ArrayList<Paragraph>();
            for (paragraphDTO paraDTO : partDTO.getParagraphs()) {
                Paragraph para = Paragraph.builder()
                        .part(part)
                        .content(paraDTO.getContent())
                        .build();
                paragraphRepository.save(para);
                paras.add(para);
            }
            part.setParagraphs(paras);

            parts.add(part);
        }


        // convert part to part Response
        List <PartResponse> partsResponses = new ArrayList<>();
        for (Part part : parts) {
            List<ParagraphResponse> paras = new ArrayList<>();
            for (Paragraph para : part.getParagraphs()){
                ParagraphResponse paraResponse = ParagraphResponse.builder()
                        .content(para.getContent())
                        .build();
                paras.add(paraResponse);
            }

            PartResponse partResponse = PartResponse.builder()
                    .urlImage(part.getUrlImage())
                    .paragraphs(paras)
                    .part_name(part.getPartName())
                    .build();
            partsResponses.add(partResponse);
        }


        PostResponse postResponse = PostResponse.builder()
                .title(post.getTitle())
                .author(post.getAuthor())
                .createdAt(post.getCreatedAt())
                .updateAt(post.getUpdateAt())
                .parts(partsResponses)
                .build();
        return postResponse;
    }

    @Override
    public Post updatePost(PostDTO postDTO) {
        return null;
    }

    @Override
    public Post detelePost(int postId) {
        return null;
    }
}
