package com.systechafrica.part2.polymorphism.animals;

public class MethodOverridingPolymorphism {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        cat.makeSound();
        dog.makeSound();
    }    
}
