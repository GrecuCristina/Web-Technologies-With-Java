package com.example.javai_interview_question_answer_platform.exception;

public class AnswerNotFoundException  extends RuntimeException{

    public AnswerNotFoundException(int id) {

        super("The answer with id = "+ id + " was not found" );
    }
}
