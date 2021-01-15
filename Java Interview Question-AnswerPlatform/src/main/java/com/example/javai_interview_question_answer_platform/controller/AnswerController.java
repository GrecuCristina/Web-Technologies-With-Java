package com.example.javai_interview_question_answer_platform.controller;

import com.example.javai_interview_question_answer_platform.dto.AnswerDto;
import com.example.javai_interview_question_answer_platform.mapper.AnswerMapper;
import com.example.javai_interview_question_answer_platform.model.Answer;
import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.service.AnswerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerMapper answerMapper;
    private AnswerService answerService;

    public AnswerController(AnswerMapper answerMapper, AnswerService answerService) {
        this.answerMapper = answerMapper;
        this.answerService = answerService;
    }


    @PostMapping
    @ApiOperation(value = "Create an Answer",
            notes = "Creates a new Answer based on the information received in the request")
    public ResponseEntity<Answer> addAnswer(@Valid @RequestBody AnswerDto answerDto){

        Answer answer = answerMapper.answerDtoToAnswer(answerDto);
        Answer createdAnswer = answerService.addAnswer(answer);
        return ResponseEntity
                .created(URI.create("/answer/" + createdAnswer.getId()))
                .body(createdAnswer);

    }
    @GetMapping("/{questionId}")
    @ApiOperation(value = "Get all answers",
            notes = "Get all answers for a certain posted question - based on the information received in the request")
    public ResponseEntity<List<Answer>> getAllAnswers(@PathVariable int questionId) {
        List<Answer> answerList = answerService.getAllAnswers(questionId);
        return new ResponseEntity<>(answerList, HttpStatus.OK);
    }
}
