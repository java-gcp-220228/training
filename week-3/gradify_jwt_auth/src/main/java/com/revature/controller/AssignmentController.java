package com.revature.controller;

import com.revature.model.User;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.UnauthorizedResponse;

public class AssignmentController implements Controller {

    // This endpoint should only be accessible by trainers
    private Handler getAllAssignments = (ctx) -> {

    };

    @Override
    public void mapEndpoints(Javalin app) {
        app.get("/assignments", getAllAssignments);
    }
}
