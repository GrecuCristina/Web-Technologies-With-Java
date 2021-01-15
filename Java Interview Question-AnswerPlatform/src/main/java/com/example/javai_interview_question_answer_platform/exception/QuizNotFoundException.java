package com.example.javai_interview_question_answer_platform.exception;

public class QuizNotFoundException  extends  RuntimeException{
    public QuizNotFoundException(int id) {
        super("Quiz with id = "+ id + "not found");
    }
}
