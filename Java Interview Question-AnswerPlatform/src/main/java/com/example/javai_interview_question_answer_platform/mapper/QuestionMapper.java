package com.example.javai_interview_question_answer_platform.mapper;

import com.example.javai_interview_question_answer_platform.dto.QuestionDto;
import com.example.javai_interview_question_answer_platform.model.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {

    public Question questionDtoToQuestion(QuestionDto questionDto){
        return new Question(questionDto.getDescription(),questionDto.getJobType(),questionDto.getUserId(), questionDto.getCompanyName());
    }
}
