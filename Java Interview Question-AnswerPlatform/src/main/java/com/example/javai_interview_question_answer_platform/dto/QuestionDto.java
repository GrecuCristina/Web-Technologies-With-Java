package com.example.javai_interview_question_answer_platform.dto;

import com.example.javai_interview_question_answer_platform.model.JobType;
import com.example.javai_interview_question_answer_platform.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class QuestionDto {
    @NotBlank(message = "Question can't be empty")
    private String description;
    @NotNull(message = "type can't be empty")
    private JobType jobType;
    private Date date;

    private User author;

    public QuestionDto(String description, JobType jobType, Date date, User author) {
        this.description = description;
        this.jobType = jobType;
        this.date = date;
        this.author = author;
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
