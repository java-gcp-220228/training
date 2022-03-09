package com.revature.controller;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class HelloWorldController implements Controller {

    private Handler getTest = (ctx) -> {
        ctx.html("<h1>GET /test</h1>");
    };

    private Handler postTest = (ctx) -> {
        ctx.html("<h1>POST /test</h1>");
    };

    private Handler putTest = (ctx) -> {
        ctx.html("<h1>PUT /test</h1>");
    };

    private Handler patchTest = (ctx) -> {
        ctx.html("<h1>PATCH /test</h1>");
    };

    private Handler deleteTest = (ctx) -> {
        ctx.html("<h1>DELETE /test</h1>");
    };

    @Override
    public void mapEndpoints(Javalin app) {
        app.get("/test", getTest);
        app.post("/test", postTest);
        app.put("/test", putTest);
        app.patch("/test", patchTest);
        app.delete("/test", deleteTest);
    }

}
