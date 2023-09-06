package com.systechafrica.part2;



public class ClassesDemo{
    // constructors are methods used to make instances of a particular class
    // constructors have the same name as the class 
    // constructors do not have return types
    public static void main(String[] args) {
        
    }
    public void cars(){
        Car mercedes= new Car();
        mercedes.make="Mercedes c250";
        mercedes.accelerate();
    }
    public void intern(){
        Intern mabera= new Intern("Martin", "martinmaati31@gmail.com", "254799692741");
        mabera.doAssignment();
    }
}
