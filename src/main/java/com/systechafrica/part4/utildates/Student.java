package com.systechafrica.part4.utildates;

public class Student {
    private String firstName;
    private String email;
    private int regNo;
    
    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", email=" + email + ", regNo=" + regNo + "]";
    }
    public Student() {
    }
    public Student(String firstName, String email, int regNo) {
        this.firstName = firstName;
        this.email = email;
        this.regNo = regNo;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getRegNo() {
        return regNo;
    }
    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }
    
    
    
}
