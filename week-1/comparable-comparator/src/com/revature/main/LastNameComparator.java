package com.revature.main;

import com.revature.model.Person;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Person> {

    // 0 o1 is equal to o2
    // >0 o1 is greater than o2
    // <0 o1 is less than o2

    // "Third-party" ordering of Person objects
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }

}
