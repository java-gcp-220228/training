package com.revature.candymicroservice.controllers;

import com.revature.candymicroservice.models.Candy;
import com.revature.candymicroservice.services.CandyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candy")
public class CandyController {
    @Autowired
    private CandyService candyService;

    @GetMapping("/test")
    public String test(){
        return "this is a candy test endpoint";
    }

    @GetMapping("/all")
    public List<Candy> getAllCandies(){
        return candyService.getAll();
    }

    @GetMapping("/{id}")
    public void getCandyById(@PathVariable ("id") int candyId){
        candyService.getById(candyId);
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
    public void deleteCandyById(@PathVariable("id") int candyId){
        candyService.deleteCandyById(candyId);
    }
}
