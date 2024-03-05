package com.example.Post.repositories;

import com.example.Post.model.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParagraphRepository extends JpaRepository<Paragraph, Integer> {
    List<Paragraph> findByPartId(int partId);
}
