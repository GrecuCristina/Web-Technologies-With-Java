package com.example.javai_interview_question_answer_platform.model;

public class Answer {

    private int id;
    private String description;
    private final User author;


    public Answer(String description, User author) {
        this.id = id;
        this.description = description;
        this.author = author;
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

    public User getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", author=" + author +
                '}';
    }
}
