package com.systechafrica.part2;

public class Person {
    private String name;
    private String email;

    public Person(String name, String email){
        this.email=email;
        this.name=name;
    }
    // setters and getters
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return email+""+name;
    }
    public void printPersonalDetails(){
        System.out.println(email+" "+name);
    }
    private String getPersonalDEtails(){
        return email+" "+name;
    }
}
