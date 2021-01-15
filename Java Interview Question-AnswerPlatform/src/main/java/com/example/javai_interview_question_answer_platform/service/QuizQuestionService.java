package com.example.javai_interview_question_answer_platform.service;

import com.example.javai_interview_question_answer_platform.exception.QuizNotFoundException;
import com.example.javai_interview_question_answer_platform.model.Quiz;
import com.example.javai_interview_question_answer_platform.model.QuizQuestion;
import com.example.javai_interview_question_answer_platform.repository.QuizQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizQuestionService {
    private QuizQuestionRepository quizQuestionRepository;


    public QuizQuestionService(QuizQuestionRepository quizQuestionRepository) {
        this.quizQuestionRepository = quizQuestionRepository;

    }
    public List<QuizQuestion> getAll(int id) {

        return quizQuestionRepository.getAll(id);
    }
    public Optional<QuizQuestion> getById(int id) {

        return quizQuestionRepository.getById(id);
    }
}
