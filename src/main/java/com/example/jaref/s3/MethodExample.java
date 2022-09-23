package com.example.jaref.s3;

import java.lang.reflect.Method;

import com.example.jaref.Dog;

public class MethodExample {
    /**
     * Examples for getMethods()
     * 
     * Getting public methods from a class / interface
     */
    private static void publicMethods() {
        System.out.println("Dog public methods:");
        for (Method method : Dog.class.getMethods()) {
            System.out.println(method);
        }
        System.out.println("---");
        System.out.println("AutoCloseable public methods:");
        for (Method method : AutoCloseable.class.getMethods()) {
            System.out.println(method);
        }
        System.out.println("---");
    }

    /**
     * Examples for getDeclaredMethod()
     * 
     * Getting a method from a class / interface
     */
    private static void declaredMethod() {
        System.out.println("Accessing Dog::barkDetails()");
        try {
            Method method = Dog.class.getDeclaredMethod("barkDetails");
            System.out.println(method);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Accessing Dog::barkDetails(int)");
        try {
            Method method = Dog.class.getDeclaredMethod("barkDetails", int.class);
            System.out.println(method);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---");
    }

    /**
     * Example for invoke()
     * 
     * Invoking
     */
    private static void invokeMethod() {
        System.out.println("Executing private method bypassing visibility rules");
        Dog bob = new Dog("Bob");

        try {
            Method b1 = Dog.class.getDeclaredMethod("barkDetails");

            System.out.print("Invoking " + b1.getName() + ": ");
            b1.setAccessible(true);
            b1.invoke(bob);

            Method b2 = Dog.class.getDeclaredMethod("barkDetails", int.class);

            System.out.print("Invoking " + b2.getName() + ": ");
            b2.setAccessible(true);
            b2.invoke(bob, 42);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---");
    }

    public static void main(String[] args) {
        publicMethods();
        declaredMethod();
        invokeMethod();
    }
}
