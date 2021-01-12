package com.example.javai_interview_question_answer_platform.controller;

import com.example.javai_interview_question_answer_platform.dto.QuestionDto;
import com.example.javai_interview_question_answer_platform.dto.UserDto;
import com.example.javai_interview_question_answer_platform.mapper.QuestionMapper;
import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.model.User;
import com.example.javai_interview_question_answer_platform.service.QuestionService;
import com.example.javai_interview_question_answer_platform.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionMapper questionMapper;


    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    @PostMapping
    public ResponseEntity<Question> addQuestion(@Valid @RequestBody QuestionDto questionDto){


        Question question = questionMapper.questionDtoToQuestion(questionDto);
        Question createdQuestion = questionService.addQuestion(question);
        return ResponseEntity
                .created(URI.create("/question/" + createdQuestion.getId()))
                .body(createdQuestion);

    }

    @DeleteMapping(value = "/{userId}/{id}")
    public Boolean remove(@PathVariable("userId") int userId, @PathVariable("id") int id)  {

        boolean removed = questionService.removeQuestion(userId, id);
        return removed;
    }
    @GetMapping
    public ResponseEntity<List<Question>> getAll() {
        List<Question> questionList = questionService.getAll();
        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }

}
