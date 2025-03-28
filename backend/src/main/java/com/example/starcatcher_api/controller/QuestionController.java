package com.example.starcatcher_api.controller;

import com.example.starcatcher_api.model.Question;
import com.example.starcatcher_api.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:8081") 
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // Endpoint para obter todas as perguntas
    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionService.findAll());
    }

    // Endpoint para obter 10 perguntas aleatórias
    @GetMapping("/random")
    public ResponseEntity<List<Question>> getRandomQuestions() {
        return ResponseEntity.ok(questionService.findRandomQuestions());
    }

    // Endpoint para verificar a resposta de uma pergunta
    @PostMapping("/{id}/check")
    public ResponseEntity<Map<String, Object>> checkAnswer(
            @PathVariable Long id,
            @RequestParam String userAnswer
    ) {
        Map<String, Object> response = questionService.checkAnswer(id, userAnswer);
        return ResponseEntity.ok(response);
    }

    // Endpoint para verificar respostas de várias perguntas
    @PostMapping("/check-all")
    public ResponseEntity<Map<String, Object>> checkAllAnswers(
            @RequestBody List<Map<String, String>> userAnswers
    ) {
        Map<String, Object> response = questionService.checkAllAnswers(userAnswers);
        return ResponseEntity.ok(response);
    }
}