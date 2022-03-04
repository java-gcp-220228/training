package com.revature.main;

public class MySingleton {

    private static MySingleton instance;

    private MySingleton() { // we don't want code in other classes to be able to instantiate an instance of this class
    }

    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }

        return instance;
    }

}
