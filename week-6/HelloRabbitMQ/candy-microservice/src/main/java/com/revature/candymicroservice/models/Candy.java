package com.revature.candymicroservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="candy_tb")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Candy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "candy_id")
    private int id;

    @Column(name = "candy_name")
    private String name;

    @Column(name = "candy_description")
    private String description;

    @Column(name = "candy_price")
    private double price;
}
