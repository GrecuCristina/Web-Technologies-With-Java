package com.example.javai_interview_question_answer_platform.exception;

public class UserAlreadyLoggedInException  extends RuntimeException{
    public UserAlreadyLoggedInException() {
        super("You are already loggedn in");
    }
}