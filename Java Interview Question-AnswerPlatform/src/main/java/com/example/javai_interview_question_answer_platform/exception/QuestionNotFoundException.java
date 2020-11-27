package com.example.javai_interview_question_answer_platform.exception;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException() {
        super("Question not found");
    }
}
