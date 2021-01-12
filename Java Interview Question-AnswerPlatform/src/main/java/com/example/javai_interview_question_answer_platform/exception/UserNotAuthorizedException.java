package com.example.javai_interview_question_answer_platform.exception;
public class UserNotAuthorizedException  extends RuntimeException{

    public UserNotAuthorizedException(int id) {
        super( "user with id =" +id+" is not authorized to do this action");
    }
}