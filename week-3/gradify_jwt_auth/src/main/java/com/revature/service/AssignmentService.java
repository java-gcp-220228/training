package com.revature.service;

import com.revature.dao.AssignmentDao;
import com.revature.dto.AddAssignmentDTO;
import com.revature.dto.ResponseAssignmentDTO;
import com.revature.model.Assignment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssignmentService {

    private AssignmentDao assignmentDao;

    public AssignmentService() {
        this.assignmentDao = new AssignmentDao();
    }

    public AssignmentService(AssignmentDao mockDao) {
        this.assignmentDao = mockDao;
    }

    public List<ResponseAssignmentDTO> getAllAssignmentsByUserId(int userId) throws SQLException {
        List<Assignment> assignments = this.assignmentDao.getAllAssignmentsByUserId(userId);

        List<ResponseAssignmentDTO> dtos = new ArrayList<>();
        for (Assignment a : assignments) {
            dtos.add(new ResponseAssignmentDTO(a.getId(), a.getAssignmentName(), a.getGrade(),
                    a.getStudent().getUsername(), a.getGrader().getUsername()));
        }

        return dtos;
    }

    public ResponseAssignmentDTO gradeAssignment(String assignmentId, String grade, int graderId) throws SQLException {
        try {
            int intAssignmentId = Integer.parseInt(assignmentId);
            int intGrade = Integer.parseInt(grade);

            Assignment assignment = this.assignmentDao.gradeAssignment(intAssignmentId, intGrade, graderId);

            return new ResponseAssignmentDTO(assignment.getId(), assignment.getAssignmentName(), assignment.getGrade(),
                    assignment.getStudent().getUsername(), assignment.getGrader().getUsername());
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Assignment ID and grade provided must be int values");
        }
    }

    public ResponseAssignmentDTO addAssignment(int studentId, AddAssignmentDTO dto) throws SQLException {
        Assignment assignmentAdded = this.assignmentDao.addAssignment(studentId, dto);

        return new ResponseAssignmentDTO(assignmentAdded.getId(), assignmentAdded.getAssignmentName(),
                assignmentAdded.getGrade(), assignmentAdded.getStudent().getUsername(), null);
    }

    public List<ResponseAssignmentDTO> getAllAssignments() throws SQLException {
        List<Assignment> assignments = this.assignmentDao.getAllAssignments();

        List<ResponseAssignmentDTO> assignmentDTOs = new ArrayList<>();

        for (Assignment assignment : assignments) {
            assignmentDTOs.add(new ResponseAssignmentDTO(assignment.getId(), assignment.getAssignmentName(),
                    assignment.getGrade(), assignment.getStudent().getUsername(), assignment.getGrader().getUsername()));
        }

        return assignmentDTOs;
    }

}
