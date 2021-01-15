package com.example.javai_interview_question_answer_platform.controller;

import com.example.javai_interview_question_answer_platform.model.Quiz;
import com.example.javai_interview_question_answer_platform.service.QuizService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping()
    @ApiOperation(value = "Get All Quizzes",
            notes = "Get all quizzes - based on the information received in the request")
    public ResponseEntity<List<Quiz>> getAll() {
        List<Quiz> list = quizService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{quizId}")
    @ApiOperation(value = "Get All Questions and Answers for a quiz",
            notes = " Get All Questions and possible answers for a certain quiz- based on the information received in the request")
    public  String getQuizQuestions(@PathVariable int quizId) {
       return quizService.showQuiz(quizId);
    }
}
