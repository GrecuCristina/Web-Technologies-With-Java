package com.example.javai_interview_question_answer_platform.exception;

public class UserNotFoundException  extends RuntimeException{
    public UserNotFoundException() {
        super("Invalid Credentials");
    }
    public UserNotFoundException(int id) {
        super("The user with id = "+ id + " was not found" );
    }
}
