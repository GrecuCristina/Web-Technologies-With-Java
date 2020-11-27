package com.example.javai_interview_question_answer_platform.model;

public class Answer {

    private int id;
    private String description;
    private final User author;


    public Answer(int id, String description, User author) {
        this.id = id;
        this.description = description;
        this.author = author;
    }
}
