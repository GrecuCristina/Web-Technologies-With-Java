package com.example.javai_interview_question_answer_platform.exception.advice;

import com.example.javai_interview_question_answer_platform.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handle(UserNotFoundException e){
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
