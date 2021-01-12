package com.example.javai_interview_question_answer_platform.exception.advice;

import com.example.javai_interview_question_answer_platform.exception.*;
import com.example.javai_interview_question_answer_platform.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{


    @ExceptionHandler(UserNotAuthorizedException.class)
    public ResponseEntity handle(UserNotAuthorizedException e){
        return ResponseEntity
                .badRequest().body(e.getMessage());
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity handle(DuplicateEmailException e){
        return ResponseEntity
                .badRequest().body(e.getMessage());
    }

    @ExceptionHandler(UserNotLoggedInException.class)
    public ResponseEntity handle(UserNotLoggedInException e){
        return ResponseEntity
                .badRequest().body(e.getMessage());
    }

    @ExceptionHandler(UserAlreadyLoggedInException.class)
    public ResponseEntity handle(UserAlreadyLoggedInException e){
        return ResponseEntity
                .badRequest().body(e.getMessage());
    }
    @ExceptionHandler(NoReviewException.class)
    public ResponseEntity handle(NoReviewException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(AnswerNotFoundException.class)
    public ResponseEntity handle(AnswerNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handle(UserNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(QuestionNotFoundException.class)
    public ResponseEntity handle(QuestionNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handle(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest()
                .body("Invalid value : " + e.getFieldError().getRejectedValue() +
                        " for field " + e.getFieldError().getField() +
                        " with message " + e.getFieldError().getDefaultMessage());
    }
}
