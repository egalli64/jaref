package com.example.jaref.s2;

public class ClassExample {
    /**
     * Examples for class literal
     * 
     * Getting a Class object from a class / interface
     */
    private static void classLiteral() {
        System.out.println("Using literal class");
        Class<Integer> ci = Integer.class;
        System.out.println(ci);

        Class<Integer> cip = int.class;
        System.out.println(cip);

        Class<AutoCloseable> cc = AutoCloseable.class;
        System.out.println(cc);
        System.out.println("---");
    }

    /**
     * Example for getClass()
     * 
     * Getting a Class object from an object
     */
    private static void callingGetClass() {
        System.out.println("Using getClass()");
        Integer i = 42;
        Class<?> ci = i.getClass();
        System.out.println(ci);
        System.out.println("---");
    }

    /**
     * Examples for Class.forName()
     * 
     * Getting a Class object from a class / interface
     */
    private static void classForName() {
        System.out.println("Using forName()");
        try {
            Class<?> ci = Class.forName("java.lang.Integer");
            System.out.println(ci);

            Class<?> cac = Class.forName("java.lang.AutoCloseable");
            System.out.println(cac);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("---");
    }

    /**
     * Example for Class::newInstance()
     * 
     * Creating an object by reflection - no argument can be passed
     */
    private static void classNewInstance() {
        System.out.println("Creating an object by newInstance()");
        try {
            // Deprecated since Java 9
            @SuppressWarnings("deprecation")
            String s = String.class.newInstance();

            System.out.println("A string with length " + s.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---");
    }

    public static void main(String[] args) {
        classLiteral();
        callingGetClass();
        classForName();
        classNewInstance();
    }
}
