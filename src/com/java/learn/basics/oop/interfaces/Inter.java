package com.java.learn.basics.oop.interfaces;

public interface Inter {
    public abstract void method();

    default void show(){
        System.out.println("interface 中的show方法");
    }
}
