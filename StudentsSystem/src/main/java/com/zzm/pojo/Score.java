package com.zzm.pojo;

/**
 * @author ZZM
 * @creatTime 2022-09-06  21:55
 */


public class Score {
    Integer studentNumber;
    Double chinese;
    Double math;
    Double english;
    Double averageScore;
    Integer position;
    Double studentScore;
    Double moralScore;
    Double teacherScore;
    Double finalScore;
    Integer fianlPosition;

    public Score() {
    }

    public Score(Integer studentNumber, Double chinese, Double math, Double english, Double averageScore, Integer position, Double studentScore, Double moralScore, Double teacherScore, Double finalScore, Integer fianlPosition) {
        this.studentNumber = studentNumber;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.averageScore = averageScore;
        this.position = position;
        this.studentScore = studentScore;
        this.moralScore = moralScore;
        this.teacherScore = teacherScore;
        this.finalScore = finalScore;
        this.fianlPosition = fianlPosition;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Double getChinese() {
        return chinese;
    }

    public void setChinese(Double chinese) {
        this.chinese = chinese;
    }

    public Double getMath() {
        return math;
    }

    public void setMath(Double math) {
        this.math = math;
    }

    public Double getEnglish() {
        return english;
    }

    public void setEnglish(Double english) {
        this.english = english;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Double getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(Double studentScore) {
        this.studentScore = studentScore;
    }

    public Double getMoralScore() {
        return moralScore;
    }

    public void setMoralScore(Double moralScore) {
        this.moralScore = moralScore;
    }

    public Double getTeacherScore() {
        return teacherScore;
    }

    public void setTeacherScore(Double teacherScore) {
        this.teacherScore = teacherScore;
    }

    public Double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }

    public Integer getFianlPosition() {
        return fianlPosition;
    }

    public void setFianlPosition(Integer fianlPosition) {
        this.fianlPosition = fianlPosition;
    }

    @Override
    public String toString() {
        return "Score{" +
                "studentNumber=" + studentNumber +
                ", chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                ", averageScore=" + averageScore +
                ", position=" + position +
                ", studentScore=" + studentScore +
                ", moralScore=" + moralScore +
                ", teacherScore=" + teacherScore +
                ", finalScore=" + finalScore +
                ", fianlPosition=" + fianlPosition +
                '}';
    }
}
