package com.systechafrica.part3.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkingWithCollections {
    public static void main(String[] args) {
        workingWithSets();
        // workingWithLists();
    }
    private static void workingWithLists(){
        List<Student> students = new ArrayList<>();
        Student john = new Student("John","003","john@gmail.com");
        Student matoo = new Student("martin","004","mabera@gmail.com");
        students.add(0, matoo);
        students.add(1, john);

        System.out.println(students);
    }
    private static void workingWithSets(){
        Set<Student> students = new HashSet<>();
        Student john = new Student("John","003","john@gmail.com");
        Student matoo = new Student("martin","004","mabera@gmail.com");
        Student jeff = new Student("jeff","005","jeff@gmail.com");

        students.add(matoo);
        students.add(jeff);
        students.add(john);
        students.add(john);

        // for each student in the student collection
        for (Student student :students){
            System.out.println(student);
        }
        System.out.println("student.size() "+students.size());
        System.out.println("students.isEmpty() "+students.isEmpty());
        System.out.println("students.contains(john) "+students.contains(john));
    }

    
}
