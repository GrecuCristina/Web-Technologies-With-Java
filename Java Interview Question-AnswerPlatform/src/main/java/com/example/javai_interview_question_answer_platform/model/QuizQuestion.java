package com.example.javai_interview_question_answer_platform.model;

public class QuizQuestion {
    private int id;
    private int quizId;
    private String description;
    private int point;

    public QuizQuestion(int id, int quizId, String description, int point) {
        this.id = id;
        this.quizId = quizId;
        this.description = description;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "QuizQuestion{" +
                "id=" + id +
                ", quizId=" + quizId +
                ", description='" + description + '\'' +
                ", point=" + point +
                '}';
    }
}
