package com.revature.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="ers_reimb")
public class Reimbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "reimb_amount", nullable = false)
    private double amount;

    @JoinColumn(name="reimb_author")
    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE) //if user is deleted then it will also delete all of their reimbs
    private User author;

    @Column(name = "reimb_description")
    private String description;

    public Reimbursement() {
    }

    public Reimbursement(double amount, User author, String description) {
        this.amount = amount;
        this.author = author;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amount=" + amount +
                ", author=" + author +
                ", description='" + description + '\'' +
                '}';
    }
}
