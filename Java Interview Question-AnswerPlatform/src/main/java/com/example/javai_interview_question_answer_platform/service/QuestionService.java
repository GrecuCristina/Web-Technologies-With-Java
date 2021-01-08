package com.example.javai_interview_question_answer_platform.service;

import com.example.javai_interview_question_answer_platform.exception.DuplicateEmailException;
import com.example.javai_interview_question_answer_platform.exception.QuestionNotFoundException;
import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.model.User;
import com.example.javai_interview_question_answer_platform.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question addQuestion(Question question){
        System.out.println("Inside question service - addQuestionMethod");
        return questionRepository.addQuestion(question);

    }

//    public boolean removeQuestion(int id) {
//        Optional<Question> question = Optional.ofNullable(questionRepository.getOneQuestion(id));
//        if(question.isPresent())
//        {
//            return questionRepository.removeQuestion(question.get(), id);
//        }
//        else{
//
//            throw new QuestionNotFoundException();
//        }
//
//    }
}
