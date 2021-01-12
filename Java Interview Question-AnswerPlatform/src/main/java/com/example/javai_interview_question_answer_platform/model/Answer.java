package com.example.javai_interview_question_answer_platform.model;

import java.sql.Timestamp;

public class Answer {



    private int id;
    private String description;
    private Timestamp date;
    private int  authorId;
    private int questionId;

    public Answer() {
    }

    public Answer(String description, Timestamp date, int authorId, int questionId) {
        this.description = description;
        this.date = date;
        this.authorId = authorId;
        this.questionId = questionId;
    }

    public Answer(int id, String description, Timestamp date, int authorId, int questionId) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.authorId = authorId;
        this.questionId = questionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", authorId=" + authorId +
                ", questionId=" + questionId +
                '}';
    }
}
