package com.example.javai_interview_question_answer_platform.controller;

import com.example.javai_interview_question_answer_platform.model.QuizQuestion;
import com.example.javai_interview_question_answer_platform.service.QuizQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("/quizzesQuestions")
public class QuizQuestionController {

    private QuizQuestionService quizQuestionService;

    public QuizQuestionController(QuizQuestionService quizQuestionService) {
        this.quizQuestionService = quizQuestionService;
    }

    @GetMapping(value = "/{quizId}")
    public ResponseEntity<List<QuizQuestion>> getAll(@PathVariable int quizId) {
        List<QuizQuestion> list = quizQuestionService.getAll(quizId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
