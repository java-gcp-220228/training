package com.revature.dto;

import java.util.Objects;

public class AddAssignmentDTO {

    private String assignmentName;

    public AddAssignmentDTO() {
    }

    public AddAssignmentDTO(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddAssignmentDTO that = (AddAssignmentDTO) o;
        return Objects.equals(assignmentName, that.assignmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignmentName);
    }

    @Override
    public String toString() {
        return "AddAssignmentDTO{" +
                "assignmentName='" + assignmentName + '\'' +
                '}';
    }
}
