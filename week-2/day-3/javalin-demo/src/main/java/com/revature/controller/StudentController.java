package com.revature.controller;

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

    // This lambda will implicitly have "throws Exception" based on the functional interface
    // This is something to be aware of, because you might actually want to handle some exceptions
    private Handler getAllStudents = (ctx) -> {
        List<Student> students = studentService.getAllStudents();

        ctx.json(students);
    };

    private Handler getStudentById = (ctx) -> {
        String id = ctx.pathParam("studentId");

        Student student = studentService.getStudentById(id);

        ctx.json(student);
    };

    private Handler addStudent = (ctx) -> {
        Student studentToAdd = ctx.bodyAsClass(Student.class);

        Student s = studentService.addStudent(studentToAdd);

        ctx.status(201); // 201 CREATED
        ctx.json(s);
    };

    private Handler editStudent = (ctx) -> {
        Student studentToEdit = ctx.bodyAsClass(Student.class);

        Student editedStudent = studentService.editStudent(ctx.pathParam("studentId"), studentToEdit);

        ctx.status(200);
        ctx.json(editedStudent);
    };

    @Override
    public void mapEndpoints(Javalin app) {
        app.get("/students", getAllStudents);
        app.get("/students/{studentId}", getStudentById);
        app.post("/students", addStudent);
        app.put("/students/{studentId}", editStudent);
    }
}
