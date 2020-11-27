package com.example.javai_interview_question_answer_platform.mapper;

import com.example.javai_interview_question_answer_platform.dto.UserDto;
import com.example.javai_interview_question_answer_platform.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User userDtoToUser(UserDto userDto){
        return new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getAge(), userDto.getPassword());

    }
}
