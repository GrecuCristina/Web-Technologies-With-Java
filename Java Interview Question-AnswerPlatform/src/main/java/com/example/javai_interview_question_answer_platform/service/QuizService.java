package com.example.javai_interview_question_answer_platform.service;

import com.example.javai_interview_question_answer_platform.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    
    private QuestionRepository quizRepository;

    public QuizService(QuestionRepository quizRepository) {
        this.quizRepository = quizRepository;
    }
}
