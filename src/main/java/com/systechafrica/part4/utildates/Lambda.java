package com.systechafrica.part4.utildates;

public class Lambda {
    public static void main(String[] args) {
        // a lambda function that does not return a value
        GenerateReport report = (student)->{
            System.out.println("**** SYSTECH NTERNSHI PROGRAMME REPORT");
            System.out.println("1,      "+student.getFirstName());
            System.out.println("2.      "+student.getEmail());
            System.out.println("3       "+student.getRegNo());
        };

        Student student = new Student("Tony","tony@gmail.com",001);
        Student student2 = new Student("Awino", "awino@gmail.com", 002);

      report.generateReport(student);
    //   report.generateReport(student2);

    //   a lambda function that takes two arguements
    StudentCompare studentCompare = ( student3,   student4)->{
        return student3.equals(student4);
    };
    CompareStudent<Student,Student,Boolean> stCompare = (studentOne,studentTwo)->{
        String stOneName= studentOne.getFirstName();
        String stTwoName = studentTwo.getFirstName();

        return stOneName.equals(stTwoName);
    };
    // now lets compare
    stCompare.compare(student, student2);

    }
}
