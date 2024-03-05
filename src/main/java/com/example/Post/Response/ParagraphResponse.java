package com.example.Post.Response;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data//toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParagraphResponse {
    private String content;
}
