package com.systechafrica.part2.inheritance;

public class Employee {

    public Employee(int employeeNo,String employeeName, String employeeAddress){
        this.employeeNo = employeeNo;
        this.employeeName=employeeName;
        this.employeeAddress=employeeAddress;
    }
    public Employee(){
        
    }
    private int employeeNo;
    public int getEmployeeNo() {
        return employeeNo;
    }
    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }
    private String employeeName;
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    private String employeeAddress;
    public String getEmployeeAddress() {
        return employeeAddress;
    }
    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
    // override the toString method
    public String toString(){
        return "Name: "+employeeName+"NO: "+employeeNo+" ADDRESS: "+employeeAddress;
    }
    
}
