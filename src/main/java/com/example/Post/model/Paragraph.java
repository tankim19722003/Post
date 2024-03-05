package com.example.Post.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "paragraph")
@Data//toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Paragraph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "part_id", nullable=false)
    private Part part;
}
