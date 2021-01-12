package com.example.javai_interview_question_answer_platform.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Question {

    private int id;
    private String description;
    private JobType jobType;
    private Timestamp date;
    private int  userId;
    private String companyName;


    public Question(int id, String description, JobType jobType, Timestamp date, int userId, String companyName) {
        this.id = id;
        this.description = description;
        this.jobType = jobType;
        this.date = date;
        this.userId = userId;
        this.companyName = companyName;
    }

    public Question(String description, JobType jobType, int userId, String companyName) {
        this.description = description;
        this.jobType = jobType;
        this.userId = userId;
        this.companyName = companyName;
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

    public Timestamp getDate() {
        return date;
    }



    public void setDate(Timestamp date) {
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
                ", companyName='" + companyName + '\'' +
                '}';
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
