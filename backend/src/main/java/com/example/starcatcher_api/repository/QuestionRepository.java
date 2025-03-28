package com.example.starcatcher_api.repository;

import com.example.starcatcher_api.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}