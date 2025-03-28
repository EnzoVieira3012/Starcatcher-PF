package com.example.starcatcher_api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "questions")
@Data
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera automaticamente o ID pelo banco de dados
    private Long id;

    @Column(nullable = false)
    private String questionText;

    @Column(nullable = false)
    private String correctAnswer;

    @ElementCollection
    @CollectionTable(name = "question_answers", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "answer")
    private List<String> answers;

    public Question(String questionText, String correctAnswer, List<String> answers) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.answers = answers;
    }
}