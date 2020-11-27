package com.example.javai_interview_question_answer_platform.dto;

import com.example.javai_interview_question_answer_platform.model.User;

import javax.validation.constraints.NotBlank;

public class AnswerDto {
    @NotBlank(message = "Answer cannot be empty")
    private String description;
    private final User author;

    public AnswerDto(String description, User author) {
        this.description = description;
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }
}
