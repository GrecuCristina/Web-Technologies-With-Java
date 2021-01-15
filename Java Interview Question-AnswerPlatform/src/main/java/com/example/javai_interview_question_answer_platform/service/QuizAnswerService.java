package com.example.javai_interview_question_answer_platform.service;

import com.example.javai_interview_question_answer_platform.model.QuizAnswer;
import com.example.javai_interview_question_answer_platform.repository.QuizAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizAnswerService {

    private QuizAnswerRepository quizAnswerRepository;


    public QuizAnswerService(QuizAnswerRepository quizAnswerRepository) {
        this.quizAnswerRepository = quizAnswerRepository;
    }

    public List<QuizAnswer> getAll(int id) {

        return quizAnswerRepository.getAll(id);
    }
    public Optional<QuizAnswer> getById(int id){
        return quizAnswerRepository.getById(id);
    }
    public Optional<QuizAnswer> getCorrectAnswer(int questionId){
        //
        return quizAnswerRepository.getById(questionId);
    }
}
