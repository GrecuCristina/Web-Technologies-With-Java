package com.example.javai_interview_question_answer_platform.mapper;

import com.example.javai_interview_question_answer_platform.dto.AnswerDto;
import com.example.javai_interview_question_answer_platform.dto.UserDto;
import com.example.javai_interview_question_answer_platform.model.Answer;
import com.example.javai_interview_question_answer_platform.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Component
public class AnswerMapper {
    public Answer answerDtoToAnswer(AnswerDto answerDto){
        return new Answer(answerDto.getDescription(), answerDto.getAuthor());

    }
}
