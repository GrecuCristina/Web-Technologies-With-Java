package com.example.javai_interview_question_answer_platform.exception;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException() {
        super("An user with the same email already exists.");
    }
}
