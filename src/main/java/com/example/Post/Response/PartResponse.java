package com.example.Post.Response;

import com.example.Post.model.Paragraph;
import com.example.Post.model.Post;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data//toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartResponse {

   @JsonProperty("url_image")
    private String urlImage;

   @JsonProperty("paragraphs")
    private List<ParagraphResponse> paragraphs;

   @JsonProperty("part_name")
    private String part_name;
}
