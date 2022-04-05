package com.revature.HelloSpringBoot.controllers;

import com.revature.HelloSpringBoot.models.Candy;
import com.revature.HelloSpringBoot.services.CandyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Profile("prod")
@RequestMapping("/candy")
public class ProductionController {

    @Autowired
    private CandyService candyService;

    @GetMapping("/test")
    public String test(){
        return "this is a test endpoint";
    }

    @GetMapping("/all")
    public List<Candy> getAllCandies(){
        return candyService.getAll();
    }

    @PostMapping("/create")
    public Candy createNewCandy(@RequestBody Candy body){
        Candy response = candyService.createCandy(body);
        return response;
    }

    @PutMapping("/edit")
    public Candy editCandy(@RequestBody Candy target){
        return candyService.editCandy(target);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCandyById(@PathVariable ("id") int candyId){
        candyService.deleteCandyById(candyId);
    }
}
