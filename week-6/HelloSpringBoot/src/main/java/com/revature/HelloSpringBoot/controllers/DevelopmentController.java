package com.revature.HelloSpringBoot.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //tells spring that this bean is a controller obj
@Profile("dev")
public class DevelopmentController {

    @RequestMapping("/hello")
    public String greetings(){
        return "Hello Azhya";
    }
}
