package com.revature.controller;

import com.revature.model.User;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.UnauthorizedResponse;

public class AssignmentController implements Controller {

    private Handler test = (ctx) -> {
        User currentlyLoggedInUser = (User) ctx.req.getSession().getAttribute("current_user");

        if (currentlyLoggedInUser != null) {
            ctx.json(currentlyLoggedInUser);
        } else {
            ctx.json("No user is logged in!");
        }
    };

    // This endpoint should only be accessible by trainers
    private Handler getAllAssignments = (ctx) -> {
        User currentlyLoggedInUser = (User) ctx.req.getSession().getAttribute("current_user");
        if (currentlyLoggedInUser != null && currentlyLoggedInUser.getUserRole().equals("trainer")) {

            // Execute code inside of here if you are authorized as a trainer

            ctx.json("some stuff happening for the endpoint");
        } else {
            throw new UnauthorizedResponse("You are not authorized to use the /accounts endpoint");
        }
    };

    @Override
    public void mapEndpoints(Javalin app) {
        app.get("/test", test);
        app.get("/assignments", getAllAssignments);
    }
}
