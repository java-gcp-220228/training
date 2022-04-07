package com.revature.orderservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.orderservice.models.AddCandyDTO;
import com.revature.orderservice.models.Candy;
import com.revature.orderservice.models.Order;
import com.revature.orderservice.services.OrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class OrderController {

    @Autowired
    public OrderServiceImpl orderServiceImpl;

    protected Logger logger = LoggerFactory.getLogger(OrderController.class);

    public void receiveMessage(String message){
        logger.info("Received from RabbitMQ (String) " + message);
        processMessageFromRabbitMQ(message, new Order());
    }

    public void receiveMessage(byte[] message){
        logger.info("Received from RabbitMQ (String) " + message);
        processMessageFromRabbitMQ(message.toString(), new Order());
    }

    //RabbitMQ methods
    private Order processMessageFromRabbitMQ(String message, Order order){
        order.setDate(LocalDate.now());
        order.setCustomerName("Willy Wonka");
        order.setQuantity(2);
        order.setTotalPrice(13.99);

        try{
            AddCandyDTO candyDTO = new ObjectMapper().readValue(message, AddCandyDTO.class);

            //convert dto to entity
            Candy candy = new Candy(candyDTO.getId(), candyDTO.getName(), candyDTO.getDescription(), candyDTO.getPrice());

            order.setCandy(candy);

            Order target = orderServiceImpl.createNewOrder(order);

            return target;

        }catch (JsonProcessingException e){
            e.printStackTrace();
            return null;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
