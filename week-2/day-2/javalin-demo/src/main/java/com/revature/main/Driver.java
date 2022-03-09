package com.revature.main;

import com.revature.controller.Controller;
import com.revature.controller.ExceptionController;
import com.revature.controller.HelloWorldController;
import com.revature.controller.StudentController;
import io.javalin.Javalin;

public class Driver {

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        mapControllers(app, new HelloWorldController(), new StudentController(), new ExceptionController());

        app.start(); // port 8080 by default
    }

    public static void mapControllers(Javalin app, Controller... controllers) {
        for (Controller c : controllers) {
            c.mapEndpoints(app);
        }
    }

}
