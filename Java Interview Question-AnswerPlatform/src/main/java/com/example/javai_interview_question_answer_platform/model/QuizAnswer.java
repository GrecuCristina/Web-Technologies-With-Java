package com.example.javai_interview_question_answer_platform.model;

public class QuizAnswer {
    private int id;
    private int quizQuestionId;
    private String description;
    private String isCorrect;

    public QuizAnswer(int id, int quizQuestionId, String description, String isCorrect) {
        this.id = id;
        this.quizQuestionId = quizQuestionId;
        this.description = description;
        this.isCorrect = isCorrect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuizQuestionId() {
        return quizQuestionId;
    }

    public void setQuizQuestionId(int quizQuestionId) {
        this.quizQuestionId = quizQuestionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return "QuizAnswer{" +
                "id=" + id +
                ", quizQuestionId=" + quizQuestionId +
                ", description='" + description + '\'' +
                ", isCorrect='" + isCorrect + '\'' +
                '}';
    }
}
