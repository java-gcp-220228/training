package com.revature.model;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;
    private int age;

    public Person() {
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 0 (means that the current instance is equal to the parameter instance)
    // >0 (means that the current instance is greater than the parameter instance)
    // <0 (means that the current instance is less than the parameter instance)

    // NATURAL ORDERING of Person objects
    @Override
    public int compareTo(Person o) {
        // Sort by age, then by last name, then by first name
        if (this.age == o.age) {

            if (this.lastName.equals(o.lastName)) {
                return this.firstName.compareTo(o.firstName);
            }

            return this.lastName.compareTo(o.lastName);
        }

        return this.age - o.age;
    }
}
