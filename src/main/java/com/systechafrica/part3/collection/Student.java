package com.systechafrica.part3.collection;

public class Student {
    
    public Student(String name, String regno, String email) {
        this.name = name;
        this.regno = regno;
        this.email = email;
    }
    public Student(){

    }
    private String name;
    private String regno;
    private String email;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRegno() {
        return regno;
    }
    public void setRegno(String regno) {
        this.regno = regno;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", regno=" + regno + ", email=" + email + "]";
    }
    
        
}
