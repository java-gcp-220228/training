package com.revature.controller;

import com.revature.dao.StudentDao;
import com.revature.exception.StudentNotFoundException;
import com.revature.model.Student;
import com.revature.service.StudentService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.List;

public class StudentController implements Controller {

    private StudentService studentService;

    public StudentController() {
        this.studentService = new StudentService();
    }

    private Handler getAllStudents = (ctx) -> {
        List<Student> students = studentService.getAllStudents();

        ctx.json(students);
    };

    private Handler getStudentById = (ctx) -> {
        String id = ctx.pathParam("id");

        try {
            Student student = studentService.getStudentById(id);

            ctx.json(student);
        } catch (StudentNotFoundException e) {
            ctx.json(e.getMessage());
            ctx.status(404); // 404 not found
        } catch (IllegalArgumentException e) {
            ctx.json(e.getMessage());
            ctx.status(400); // 400 Bad Request
        }

    };

    @Override
    public void mapEndpoints(Javalin app) {
        app.get("/students", getAllStudents);
        app.get("/students/{id}", getStudentById);
    }
}
