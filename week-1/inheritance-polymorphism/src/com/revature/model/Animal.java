package com.revature.model;

public class Animal {

    protected int numOfLegs;

    public Animal() {
    }

    public Animal(int numOfLegs) {
        super(); // Calling the Object class' constructor
        this.numOfLegs = numOfLegs;
    }

    // Overloaded
    public void eat() {
        System.out.println("Animal is eating");
    }

    // Overloaded
    public void eat(String food) {
        System.out.println("Animal is eating " + food);
    }

    // Overloaded
    public void eat(String... food) { // ... is known as the syntax for var-args (variable arguments)
        // We can pass as many arguments as we want into this method
        // food is treated as a reference variable for a String array that represents each of the arguments

        StringBuilder sb = new StringBuilder();
        sb.append("Animal is eating ");

        for (int i = 0; i < food.length; i++) {
            sb.append(food[i] + ", ");
        }

        sb.deleteCharAt(sb.length() - 1); // delete the space
        sb.deleteCharAt(sb.length() - 1); // delete the comma

        System.out.println(sb.toString());
    }

    public void makeNoise() {
        System.out.println("**GENERIC ANIMAL NOISES**");
    }

    /*
        Getters and setters
     */
    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }
}
