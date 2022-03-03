package com.revature.model;

public class Cat extends Animal {

    private String name;

    public Cat(int numOfLegs, String name) {
        super(numOfLegs);
        this.name = name;
    }

    public void sniffCatnip() {
        System.out.println(this.name + " is sniffing catnip");
    }

    @Override
    public void makeNoise() {
        System.out.println("Meow!");
    }

    /*
        Getters and setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
