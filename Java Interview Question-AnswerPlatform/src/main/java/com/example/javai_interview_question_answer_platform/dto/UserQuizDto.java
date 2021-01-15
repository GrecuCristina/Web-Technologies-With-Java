package com.example.javai_interview_question_answer_platform.dto;

public class UserQuizDto {
    private  int uId;
    private int quId;
    private int qeId;
    private int aId;
    private int points;

    public UserQuizDto(int uId, int quId, int qeId, int aId, int points) {
        this.uId = uId;
        this.quId = quId;
        this.qeId = qeId;
        this.aId = aId;
        this.points = points;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getQuId() {
        return quId;
    }

    public void setQuId(int quId) {
        this.quId = quId;
    }

    public int getQeId() {
        return qeId;
    }

    public void setQeId(int qeId) {
        this.qeId = qeId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "UserQuizDto{" +
                "uId=" + uId +
                ", quId=" + quId +
                ", qeId=" + qeId +
                ", aId=" + aId +
                ", points=" + points +
                '}';
    }
}
