package com.example.Post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PartDTO {
    List <paragraphDTO> paragraphs;
    @JsonProperty("url_image")
    private String urlImage;

    @JsonProperty("part_name")
    private String partName;
}
