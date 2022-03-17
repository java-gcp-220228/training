package com.revature.controller;

import com.revature.dto.LoginDTO;
import com.revature.model.User;
import com.revature.service.UserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import javax.security.auth.login.FailedLoginException;
import javax.servlet.http.HttpSession;

public class AuthenticationController implements Controller {

    private UserService userService;

    public AuthenticationController() {
        this.userService = new UserService();
    }

    private Handler login = (ctx) -> {
        System.out.println("Login endpoint invoked");

        LoginDTO loginInfo = ctx.bodyAsClass(LoginDTO.class);

        User user = userService.login(loginInfo.getUsername(), loginInfo.getPassword());
        // If FailedLoginException did not occur, then we will move on to the subsequent lines of code

        // Code down here will not run if FailedLoginException happened from the .login(..., ...) method
        HttpSession session = ctx.req.getSession(); // ctx.req is an HttpServletRequest object
        // Behind the scenes, Javalin utilizes Java EE Servlets to handle HTTP requests. We're making use of the
        // Servlet API to create an HttpSession

        session.setAttribute("current_user", user); // Set the User object to this session

        ctx.json(user);
    };

    private Handler logout = (ctx) -> {
      HttpSession session = ctx.req.getSession();

      session.invalidate(); // Invalidate the HttpSession on the backend
    };

    @Override
    public void mapEndpoints(Javalin app) {
        app.post("/login", login);
        app.post("/logout", logout);
    }
}
