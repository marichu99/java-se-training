package com.systechafrica.part4.utildates;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        
        Function<Student,Boolean> studentFunction = student -> student.getFirstName().equals("mabera");

        Student student = new Student("Tony","tony@gmail.com",001);
        Student student2 = new Student("Awino", "awino@gmail.com", 002);
        System.out.println(studentFunction.apply(student2));

        // function generic that takes two arguements
        BiFunction<Student,Student,Boolean> studentCompare =(studentOne,studentTwo) ->{
            System.out.println(studentOne.getFirstName());
            System.out.println(studentTwo.getFirstName());

            return studentOne.getFirstName().equals(studentTwo.getFirstName());
        };
        System.out.println(studentCompare.apply(student, student2));
        // an interfaces that is a bifunctional generic
        CompareStudent<Student,Student,Boolean> studentCompared =(studentOne,studentTwo)->{
            System.out.println(studentOne.getFirstName());
            System.out.println(studentTwo.getFirstName());

            return studentOne.getFirstName().equals(studentTwo.getFirstName());
        };
        System.out.println(studentCompared.compare(student, student2));
    }
    
}
