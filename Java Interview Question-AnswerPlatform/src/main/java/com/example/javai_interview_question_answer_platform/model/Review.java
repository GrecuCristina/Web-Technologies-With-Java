package com.example.javai_interview_question_answer_platform.model;

import java.sql.Timestamp;

public class Review {

    private int id;
    private ReviewType  reviewType;
    private Timestamp date;
    private int  userReviewId;
    private int answerId;

    public Review(int id, ReviewType reviewType, Timestamp date, int userReviewId, int answerId) {
        this.id = id;
        this.reviewType = reviewType;
        this.date = date;
        this.userReviewId = userReviewId;
        this.answerId = answerId;
    }

    public Review(ReviewType reviewType, Timestamp date, int userReviewId, int answerId) {
        this.reviewType = reviewType;
        this.date = date;
        this.userReviewId = userReviewId;
        this.answerId = answerId;
    }

    public Review(ReviewType reviewType, int userReviewId, int answerId) {
        this.reviewType = reviewType;
        this.userReviewId = userReviewId;
        this.answerId = answerId;
    }

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReviewType getReviewType() {
        return reviewType;
    }

    public void setReviewType(ReviewType reviewType) {
        this.reviewType = reviewType;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getUserReviewId() {
        return userReviewId;
    }

    public void setUserReviewId(int userReviewId) {
        this.userReviewId = userReviewId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", reviewType=" + reviewType +
                ", date=" + date +
                ", userReviewId=" + userReviewId +
                ", answerId=" + answerId +
                '}';
    }
}
