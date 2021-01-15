package com.example.javai_interview_question_answer_platform.controller;

import com.example.javai_interview_question_answer_platform.dto.UserQuizDto;
import com.example.javai_interview_question_answer_platform.exception.QuizNotFoundException;
import com.example.javai_interview_question_answer_platform.exception.UserNotFoundException;
import com.example.javai_interview_question_answer_platform.exception.UserNotLoggedInException;
import com.example.javai_interview_question_answer_platform.mapper.UserQuizMapper;
import com.example.javai_interview_question_answer_platform.model.*;
import com.example.javai_interview_question_answer_platform.service.UserQuizService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/userQuiz")
public class UserQuizController {



    private final UserQuizMapper userQuizMapper;
    private UserQuizService userQuizService;


    public UserQuizController(UserQuizMapper userQuizMapper, UserQuizService userQuizService) {
        this.userQuizMapper = userQuizMapper;
        this.userQuizService = userQuizService;
    }


    @PostMapping
    @ApiOperation(value = "Create an answer to a question for a quiz",
            notes = "Adds an answer to a question for a quiz - based on the information received in the request")
    public ResponseEntity<UserQuiz> create(@Valid @RequestBody UserQuizDto userQuizDto){

        UserQuiz userQuiz = userQuizMapper.userQuizDtoToUserQuiz(userQuizDto);
        UserQuiz createdUserQuiz = userQuizService.create(userQuiz);
        return ResponseEntity
                .created(URI.create("/user/" + createdUserQuiz.getId()))
                .body(createdUserQuiz);



    }
    @GetMapping(value = "/{userId}/{quizId}")
    @ApiOperation(value = "Get score for quiz",
            notes = "Shows score for a certain user and quiz - based on the information received in the request")
    public int getScore(@PathVariable int userId, @PathVariable int quizId){
        return userQuizService.quizScore(userId, quizId);
    }

    @GetMapping(value = "/quizCorrectAnswers/{userId}/{quizId}")
    @ApiOperation(value = "Get correct answers to all the questions for a quiz",
            notes = "Get correct answers to all the questions for a quiz - based on the information received in the request")
    public String QuizCorrectAnswers(@PathVariable  int userId, @PathVariable int quizId){
      return userQuizService.QuizCorrectAnswers(userId, quizId);
    }
}
