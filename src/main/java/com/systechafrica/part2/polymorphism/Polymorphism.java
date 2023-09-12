package com.systechafrica.part2.polymorphism;

import com.systechafrica.part2.inheritance.Employee;
import com.systechafrica.part2.inheritance.QualityAssurance;
import com.systechafrica.part2.inheritance.SoftwareEngineer;

public class Polymorphism {
    public static void main(String[] args) {
        Employee martin = new QualityAssurance(001, "martin mabera", "DOWNING ST ", "NUMBER 10");
        Employee tim = new SoftwareEngineer(001, "martin mabera", "DOWNING ST ");
        Employee alex = new SoftwareEngineer(001, "martin mabera", "DOWNING ST ");


    }
    
    
}
