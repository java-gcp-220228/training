package com.revature.main;

import com.revature.model.Animal;
import com.revature.model.Cat;
import com.revature.model.Dog;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Dog d1 = new Dog(4, "Fido");
        System.out.println(d1.getName());
        System.out.println(d1.getNumOfLegs());

        Animal a1 = new Dog(4, "Sparky");
        System.out.println(((Dog) a1).getName()); // Notice we are casting the Animal reference variable
        // into a Dog reference variable, so that we can call getName()
        // The Animal class doesn't define the getName() method, the Dog class does
        // So, even though a1 is referring to a Dog object, we can't access all of the Dog's behaviors
        // without casting
        // Reference variable casting:
        //      1. Upcasting (Implicit) (type-safe)
        //      2. Downcasting (Explicit) (not type-safe)

        Animal a2 = new Animal(4); // a2 is referring to an Animal object

        if (a2 instanceof Dog) { // check if a2 is pointing to a Dog, and only then do some downcasting
            System.out.println( ( (Dog) a2).getName());
        } else {
            System.out.println("a2 is not pointing to a Dog, so we cannot print out a name");
        }

        Animal[] myAnimals = new Animal[4]; // null
        myAnimals[0] = new Dog(4, "Fido");
        myAnimals[1] = new Dog(4, "Sparky");
        myAnimals[2] = new Cat(4, "Whiskers");
        myAnimals[3] = new Cat(4, "Mr. Mittens");

        for (int i = 0; i < myAnimals.length; i++) {
            Animal currentAnimal = myAnimals[i];

            if (currentAnimal instanceof Dog) {
                Dog d = (Dog) currentAnimal;
                d.playFetch();
            } else if (currentAnimal instanceof Cat) {
                Cat c = (Cat) currentAnimal;
                c.sniffCatnip();
            }

            currentAnimal.makeNoise(); // If the animal is a Dog, it will bark
            // If the animal is a Cat, it will meow
            // The reference variable, which is of the type Animal, doesn't matter for this
        }

        Animal a = new Cat(4, "Tigger");
        a.eat();
        a.eat("Fish");
        a.eat("Steak", "Fish", "Catnip"); // var-args


        Scanner sc = new Scanner(System.in); // We are creating a Scanner object that will
        // "scan" System.in (console input)
        // So, the Scanner object allows for a user to send information to a program
        System.out.println("Select a Dog, Cat, or Animal: ");
        System.out.println("1.) Dog");
        System.out.println("2.) Cat");
        System.out.println("3.) Animal");
        int choice = Integer.parseInt(sc.nextLine());
        // use the static method parseInt belonging to the Integer class in order to convert
        // from a String to an int

        Animal myAnimalChoice = null;
        switch(choice) {
            case 1:
                System.out.println("Enter name of Dog: ");
                String dogName = sc.nextLine();
                System.out.println("Enter number of legs: ");
                int dogNumberOfLegs = Integer.parseInt(sc.nextLine());
                myAnimalChoice = new Dog(dogNumberOfLegs, dogName);
                break;
            case 2:
                System.out.println("Enter name of Cat: ");
                String catName = sc.nextLine();
                System.out.println("Enter number of legs: ");
                int catNumberOfLegs = Integer.parseInt(sc.nextLine());
                myAnimalChoice = new Cat(catNumberOfLegs, catName);
                break;
            default:
                System.out.println("Enter number of legs: ");
                int numberOfLegs = Integer.parseInt(sc.nextLine());
                myAnimalChoice = new Animal(numberOfLegs);
        }

        myAnimalChoice.makeNoise();

    }

}
