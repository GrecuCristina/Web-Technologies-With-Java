package com.example.javai_interview_question_answer_platform.dto;

import com.example.javai_interview_question_answer_platform.model.JobType;
import com.example.javai_interview_question_answer_platform.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class QuestionDto {
    @NotBlank(message = "Question can't be empty")

    private String description;


    private JobType jobType;

    private Timestamp date;

    @Positive(message = "userId can't be negative")
    @NotNull(message = "userId can't be empty")
    private int userId;

    @NotBlank(message = "company name cannot be empty")
    private String companyName;

    public QuestionDto(String description, JobType jobType, Timestamp date, int userId, String companyName) {
        this.description = description;
        this.jobType = jobType;
        this.date = date;
        this.userId = userId;
        this.companyName = companyName;
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

    public void setDate(Timestamp date) {
        this.date = date;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
