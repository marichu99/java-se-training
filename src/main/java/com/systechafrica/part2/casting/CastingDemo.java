package com.systechafrica.part2.casting;

import com.systechafrica.part2.polymorphism.animals.Cat;
import com.systechafrica.part2.polymorphism.animals.Animal;
import com.systechafrica.part2.polymorphism.animals.Dog;


public class CastingDemo {
    public void printInfo(Animal animal){
        Dog dog = (Dog) animal;
        dog.makeSound();
    }
    public static void main(String[] args) {
        CastingDemo app = new CastingDemo();
        Animal animal = new Animal();
        Animal animals  = new Dog();
        // animals.printName();


    }



    
}
