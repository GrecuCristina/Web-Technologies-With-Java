package com.example.javai_interview_question_answer_platform.model;

import java.util.HashMap;

public class Quiz {

    private int id;
    private int totalPoints;

    public Quiz(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Quiz(int id, int totalPoints) {
        this.id = id;
        this.totalPoints = totalPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
