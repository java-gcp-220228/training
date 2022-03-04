package com.revature.main;

import com.revature.controller.Controller;
import com.revature.controller.StudentController;
import com.revature.dao.StudentDao;
import com.revature.model.Student;
import com.revature.utility.ConnectionUtility;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        map(app, new StudentController());

        app.start();
    }

    public static void map(Javalin app, Controller... controllers) {
        for (Controller c : controllers) {
            c.mapEndpoints(app);
        }
    }

}
