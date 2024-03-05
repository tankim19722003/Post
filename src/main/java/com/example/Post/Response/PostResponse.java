package com.example.Post.Response;

import com.example.Post.model.Part;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Data//toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {
    @JsonProperty("id")
    private int id;

    private String author;

    private String thumbnail;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("update_at")
    private Date updateAt;

    @Column(name ="name")
    private String title;
    private List<PartResponse> parts;

}
