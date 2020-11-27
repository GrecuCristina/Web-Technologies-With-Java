package com.example.javai_interview_question_answer_platform.model;

import java.util.HashMap;

public class Quiz {
    //exemplu: raspunsul corect la intrebarea cu key = 1 din quizQuestion este elementul cu key = 1 din quizAnswer
    private HashMap<Integer, String> quizQuestions = new HashMap<Integer, String>();
    private HashMap<Integer, String> quizAnswers = new HashMap<Integer, String>();
    private int score;

    public Quiz(HashMap<Integer, String> quizQuestions, HashMap<Integer, String> quizAnswers, int score) {
        this.quizQuestions = quizQuestions;
        this.quizAnswers = quizAnswers;
        this.score = score;
    }

    public Quiz() {
    }

    public HashMap<Integer, String> getQuizQuestions() {
        return quizQuestions;
    }

    public void setQuizQuestions(HashMap<Integer, String> quizQuestions) {
        this.quizQuestions = quizQuestions;
    }

    public HashMap<Integer, String> getQuizAnswers() {
        return quizAnswers;
    }

    public void setQuizAnswers(HashMap<Integer, String> quizAnswers) {
        this.quizAnswers = quizAnswers;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
