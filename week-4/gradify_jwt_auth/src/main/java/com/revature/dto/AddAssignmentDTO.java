package com.revature.dto;

import java.io.InputStream;
import java.util.Objects;

public class AddAssignmentDTO {

    private String assignmentName;
    private InputStream image;

    public AddAssignmentDTO() {
    }

    public AddAssignmentDTO(String assignmentName, InputStream image) {
        this.assignmentName = assignmentName;
        this.image = image;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddAssignmentDTO that = (AddAssignmentDTO) o;
        return Objects.equals(assignmentName, that.assignmentName) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignmentName, image);
    }

    @Override
    public String toString() {
        return "AddAssignmentDTO{" +
                "assignmentName='" + assignmentName + '\'' +
                ", image=" + image +
                '}';
    }
}
