package com.revature.model;

public class A {

    // Instance scoped variables
    private int w;
    int x;
    protected int y;
    public int z;

    public A(int w, int x, int y, int z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void printProperties() {
        System.out.println("w = " + this.w + ", x = " + this.x + ", y = " + this.y + ", z = " + this.z);
    }

}
