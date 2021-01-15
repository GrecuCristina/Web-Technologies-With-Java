package com.example.javai_interview_question_answer_platform.mapper;

import com.example.javai_interview_question_answer_platform.dto.UserQuizDto;
import com.example.javai_interview_question_answer_platform.model.UserQuiz;
import org.springframework.stereotype.Component;

@Component
public class UserQuizMapper {

    public UserQuiz userQuizDtoToUserQuiz(UserQuizDto userQuizDto){
        return new UserQuiz(userQuizDto.getuId(), userQuizDto.getQuId(), userQuizDto.getQeId(), userQuizDto.getaId(), userQuizDto.getPoints());
    }
}
