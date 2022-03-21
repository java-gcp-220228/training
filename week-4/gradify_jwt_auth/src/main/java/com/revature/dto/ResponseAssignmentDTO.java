package com.revature.dto;

import java.util.Objects;

public class ResponseAssignmentDTO {

    private int id;
    private String assignmentName;
    private int grade;

    private String studentUsername;
    private String graderUsername;

    public ResponseAssignmentDTO() {
    }

    public ResponseAssignmentDTO(int id, String assignmentName, int grade, String studentUsername, String graderUsername) {
        this.id = id;
        this.assignmentName = assignmentName;
        this.grade = grade;
        this.studentUsername = studentUsername;
        this.graderUsername = graderUsername;
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

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String getGraderUsername() {
        return graderUsername;
    }

    public void setGraderUsername(String graderUsername) {
        this.graderUsername = graderUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseAssignmentDTO that = (ResponseAssignmentDTO) o;
        return id == that.id && grade == that.grade && Objects.equals(assignmentName, that.assignmentName) && Objects.equals(studentUsername, that.studentUsername) && Objects.equals(graderUsername, that.graderUsername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assignmentName, grade, studentUsername, graderUsername);
    }

    @Override
    public String toString() {
        return "GetAssignmentDTO{" +
                "id=" + id +
                ", assignmentName='" + assignmentName + '\'' +
                ", grade=" + grade +
                ", studentUsername='" + studentUsername + '\'' +
                ", graderUsername='" + graderUsername + '\'' +
                '}';
    }
}
