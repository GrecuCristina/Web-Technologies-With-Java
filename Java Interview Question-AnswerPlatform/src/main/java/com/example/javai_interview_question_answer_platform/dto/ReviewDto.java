package com.example.javai_interview_question_answer_platform.dto;

import com.example.javai_interview_question_answer_platform.model.ReviewType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Timestamp;

public class ReviewDto {


    private ReviewType reviewType;
    private Timestamp date;


    @Positive(message = "userId can't be negative")
    @NotNull(message = "userId can't be empty")
    private int  userReviewId;

    @Positive(message = "answerId can't be negative")
    @NotNull(message = "answerId can't be empty")
    private int answerId;
    public ReviewDto(ReviewType reviewType, Timestamp date, int userReviewId, int answerId) {
        this.reviewType = reviewType;
        this.date = date;
        this.userReviewId = userReviewId;
        this.answerId = answerId;
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
        return "ReviewDto{" +
                "reviewType=" + reviewType +
                ", date=" + date +
                ", userReviewId=" + userReviewId +
                ", answerId=" + answerId +
                '}';
    }
}

