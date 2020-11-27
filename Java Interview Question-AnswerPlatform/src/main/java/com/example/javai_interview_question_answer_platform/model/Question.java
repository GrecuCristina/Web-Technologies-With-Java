package com.example.javai_interview_question_answer_platform.model;

import java.util.Date;

public class Question {

    private int id;
    private String description;
    private JobType jobType;
    private Date date;
    private User author;

    public Question() {
    }

    public Question(String description, JobType jobType, User author) {
        this.description = description;
        this.jobType = jobType;

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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
