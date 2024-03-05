package com.example.Post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDTO {
    private String title;
    private String author;
    private String thumbnail;

    @JsonProperty("part_list")
    private List<PartDTO> partList;
}
