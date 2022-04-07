package com.revature.orderservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "order_tb")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int id;

    @Column(name = "order_date")
    private LocalDate date;

    @Column(name = "order_customer_name")
    private String customerName;

    @Column(name = "order_quantity")
    private int quantity;

    @Column(name = "order_total_price")
    private double totalPrice;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_item", nullable = false)
    private Candy candy;
}
