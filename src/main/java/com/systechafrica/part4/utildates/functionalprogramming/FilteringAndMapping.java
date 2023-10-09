package com.systechafrica.part4.utildates.functionalprogramming;

import java.util.List;

public class FilteringAndMapping {
    List<Student> students = List.of(
        new Student("tony","oseko","tony@gmail.com","001",1),
        new Student("lena","bett","lena@gmail.com","001",2),
        new Student("martin","ntwiga","martin@gmail.com","001",3),
        new Student("awino","mackrine","awino@gmail.com","001",4)
    );
    // students.stream().map(student -> student.getFirstName()).filter(firstName -> firstName.startsWith("martin")).foreach(name->System.out.println(name))
}