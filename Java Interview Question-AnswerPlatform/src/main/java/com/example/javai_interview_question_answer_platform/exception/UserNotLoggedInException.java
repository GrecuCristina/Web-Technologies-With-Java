package com.example.javai_interview_question_answer_platform.exception;

public class UserNotLoggedInException  extends RuntimeException{
    public UserNotLoggedInException() {
        super("You are not logged in");
    }
}