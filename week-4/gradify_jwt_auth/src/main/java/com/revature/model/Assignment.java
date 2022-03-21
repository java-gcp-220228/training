package com.revature.model;

import java.util.Objects;

public class Assignment {

    private int id;
    private String assignmentName;
    private int grade;

    private User student;
    private User grader;

    public Assignment() {
    }

    public Assignment(int id, String assignmentName, int grade, User student, User grader) {
        this.id = id;
        this.assignmentName = assignmentName;
        this.grade = grade;
        this.student = student;
        this.grader = grader;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public User getGrader() {
        return grader;
    }

    public void setGrader(User grader) {
        this.grader = grader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return id == that.id && grade == that.grade && Objects.equals(assignmentName, that.assignmentName) && Objects.equals(student, that.student) && Objects.equals(grader, that.grader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assignmentName, grade, student, grader);
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", assignmentName='" + assignmentName + '\'' +
                ", grade=" + grade +
                ", student=" + student +
                ", grader=" + grader +
                '}';
    }
}
