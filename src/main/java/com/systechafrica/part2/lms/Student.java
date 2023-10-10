package com.systechafrica.part2.lms;

public class Student {
    private String firstName;
    private String lastName;
    private int regNo;
    private boolean borrowStatus;
    
    public Student() {
    }
    
    public Student(String firstName, String lastName, int regNo, boolean borrowStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.regNo = regNo;
        this.borrowStatus = borrowStatus;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getRegNo() {
        return regNo;
    }
    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }
    public boolean isBorrowStatus() {
        return borrowStatus;
    }
    public void setBorrowStatus(boolean borrowStatus) {
        this.borrowStatus = borrowStatus;
    }
    
    
}
