package com.example.jaref.s4;

import java.lang.reflect.Field;

import com.example.jaref.Dog;

public class FieldExample {
    /**
     * Example for getFields()
     * 
     * Getting public fields
     */
    private static void publicFields() {
        Field[] fields = Dog.class.getFields();

        System.out.print("Number of public fields: ");
        System.out.println(fields.length);
        System.out.println("---");
    }

    private static void declaredField() {
        Dog bob = new Dog("Bob");

        try {
            System.out.println("Accessing private members");
            Field field = Dog.class.getDeclaredField("name");
            System.out.println(field);

            field.setAccessible(true);
            System.out.println("The dog name is " + field.get(bob));

            field.set(bob, "Robert");
            System.out.println("Dog renamed " + field.get(bob));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        publicFields();
        declaredField();
    }
}
