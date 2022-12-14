package com.example.jaref;

public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    private void barkDetails() {
        System.out.println("Private barking details");
    }

    private void barkDetails(int times) {
        System.out.println("Private int-overload barking details " + times);
    }

    public void bark() {
        barkDetails();
        System.out.println("Bark!");
    }

    public void bark(int times) {
        barkDetails(times);
        System.out.println("Bark!");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dog other = (Dog) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Dog [name=" + name + "]";
    }
}
