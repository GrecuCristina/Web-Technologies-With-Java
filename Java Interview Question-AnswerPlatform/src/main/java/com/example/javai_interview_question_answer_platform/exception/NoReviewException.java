package com.example.javai_interview_question_answer_platform.exception;


public class NoReviewException extends RuntimeException {
    public NoReviewException() {
        super("no reviews");
    }
}
