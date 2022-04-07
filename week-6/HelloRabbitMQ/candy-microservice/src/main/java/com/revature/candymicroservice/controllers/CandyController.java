package com.revature.candymicroservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.candymicroservice.models.AddCandyDTO;
import com.revature.candymicroservice.models.Candy;
import com.revature.candymicroservice.services.CandyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candy")
public class CandyController {
    @Autowired
    private CandyService candyService;

    protected Logger logger = LoggerFactory.getLogger(CandyController.class);

    @Value("${fanout.exchange}")
    private String fanoutExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

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
    public ResponseEntity<String> createNewCandy(@RequestBody Candy body) {
        //1. send body to the service layer -> should return a new entity with an id
        Candy response = candyService.createCandy(body);
        //2. convert entity to DTO
        AddCandyDTO candyDTO = new AddCandyDTO(
                response.getId(),
                response.getName(),
                response.getDescription(),
                response.getPrice()
        );

        //3. send the dto to rabbitmq exchange
        try{
            sendCandyDataToRabbitMQ(candyDTO);
            //4. send response to user
            return new ResponseEntity<String>("New candy has been created! ID: " + response.getId(),
                    new HttpHeaders(),
                    HttpStatus.CREATED);
        }catch (JsonProcessingException e) {
            //4. send response to user
            return new ResponseEntity<String>("Error in sending data into RabbitMQ: " + e.getMessage(),
                    new HttpHeaders(),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void sendCandyDataToRabbitMQ(@RequestBody AddCandyDTO candyDTO) throws JsonProcessingException {
        logger.info("Storing new candy...");
        rabbitTemplate.setExchange(fanoutExchange);
        rabbitTemplate.convertAndSend(new ObjectMapper().writeValueAsString(candyDTO));
        logger.info("Candy stored in queue successfully");
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
