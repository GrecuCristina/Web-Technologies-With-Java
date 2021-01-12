package com.example.javai_interview_question_answer_platform.dto;

import com.example.javai_interview_question_answer_platform.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class AnswerDto {
    @NotBlank(message = "Answer cannot be empty")
    private String description;

    @NotNull(message = "authorId cannot be empty")
    private int authorId;

    @NotNull(message = "questionId cannot be empty")
    private int questionId;
    private Timestamp date;

    public AnswerDto(String description, int authorId, int questionId, Timestamp date) {
        this.description = description;
        this.authorId = authorId;
        this.questionId = questionId;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int userId) {
        this.authorId= authorId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
