package com.revature.main;

@FunctionalInterface
public interface MyPredicate<T> {

    public abstract boolean test(T t);

}
