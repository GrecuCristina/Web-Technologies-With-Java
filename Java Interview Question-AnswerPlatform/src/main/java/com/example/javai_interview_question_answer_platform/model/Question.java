package com.example.javai_interview_question_answer_platform.model;

import java.util.Date;

public class Question {

    private int id;
    private String description;
    private JobType jobType;
    private Date date;
    private int  userId;

    public Question() {
    }

    public Question(String description, JobType jobType, int userId){
        this.description = description;
        this.jobType = jobType;

        this.userId = userId;
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

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", jobType=" + jobType +
                ", date=" + date +
                ", userId=" + userId +
                '}';
    }
}
