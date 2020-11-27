package com.example.javai_interview_question_answer_platform.controller;

import com.example.javai_interview_question_answer_platform.dto.AnswerDto;
import com.example.javai_interview_question_answer_platform.mapper.AnswerMapper;
import com.example.javai_interview_question_answer_platform.model.Answer;
import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@Validated
@RequestMapping("/answers")
public class AnswerController {
    private final AnswerMapper answerMapper;
    private final UserService userService ;

    public AnswerController(AnswerMapper answerMapper, UserService userService) {
        this.answerMapper = answerMapper;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Answer> addAnswer(@Valid @RequestBody AnswerDto answerDto){

        Answer answer = answerMapper.answerDtoToAnswer(answerDto);
        Answer createdAnswer = userService.addAnswer(answer);
        return ResponseEntity
                .created(URI.create("/answer/" + createdAnswer.getId()))
                .body(createdAnswer);

    }
}
