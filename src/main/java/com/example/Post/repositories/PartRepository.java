package com.example.Post.repositories;

import com.example.Post.dto.PartDTO;
import com.example.Post.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartRepository extends JpaRepository <Part, Integer> {
    List<PartDTO> findByPostId(int postId);
}
