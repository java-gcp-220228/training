package com.revature.main;

import com.revature.controller.Controller;
import com.revature.controller.ExceptionController;
import com.revature.controller.HelloWorldController;
import com.revature.controller.StudentController;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver {

    public static Logger logger = LoggerFactory.getLogger(Driver.class);

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        // This will execute before every single request
        app.before((ctx) -> {
            logger.info(ctx.method() + " request received for " + ctx.path());
        });

        mapControllers(app, new HelloWorldController(), new StudentController(), new ExceptionController());

        app.start(); // port 8080 by default
    }

    public static void mapControllers(Javalin app, Controller... controllers) {
        for (Controller c : controllers) {
            c.mapEndpoints(app);
        }
    }

}
