package com.revature.main;

import com.revature.model.A;

public class B extends A {

    public B(int w, int x, int y, int z) {
        super(w, x, y, z);
    }

    public int getY() {
        return this.y; // the B class can access y from the A class, because y is protected
        // and B is a subclass of A
    }

}
