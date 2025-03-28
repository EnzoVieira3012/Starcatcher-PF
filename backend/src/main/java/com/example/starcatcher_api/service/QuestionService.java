package com.example.starcatcher_api.service;

import com.example.starcatcher_api.model.Question;
import com.example.starcatcher_api.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // Retorna todas as perguntas
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    // Retorna 10 perguntas aleatórias
    public List<Question> findRandomQuestions() {
        List<Question> allQuestions = questionRepository.findAll(); // Busca todas as perguntas
        Collections.shuffle(allQuestions); // Embaralha as perguntas
        return allQuestions.subList(0, Math.min(10, allQuestions.size())); // Retorna até 10 perguntas
    }

    // Verifica a resposta de uma pergunta
    public Map<String, Object> checkAnswer(Long id, String userAnswer) {
        Question question = questionRepository.findById(id).orElse(null);

        Map<String, Object> response = new HashMap<>();
        if (question == null) {
            response.put("error", "Pergunta não encontrada");
            return response;
        }

        boolean isCorrect = question.getCorrectAnswer().equalsIgnoreCase(userAnswer);
        response.put("correct", isCorrect);
        response.put("correctAnswer", question.getCorrectAnswer());
        return response;
    }

    // Verifica respostas de várias perguntas
    public Map<String, Object> checkAllAnswers(List<Map<String, String>> userAnswers) {
        int correctCount = 0;

        for (Map<String, String> userAnswer : userAnswers) {
            Long questionId = Long.parseLong(userAnswer.get("id"));
            String selectedAnswer = userAnswer.get("answer");

            Question question = questionRepository.findById(questionId).orElse(null);
            if (question != null && question.getCorrectAnswer().equalsIgnoreCase(selectedAnswer)) {
                correctCount++;
            }
        }

        return Map.of("correctCount", correctCount, "totalQuestions", userAnswers.size());
    }
}