package com.systechafrica.part2.inheritance;

public class QualityAssurance extends Employee{
    private String title;
    public QualityAssurance(int employeeNo, String employeeName, String employeeAddress, String title) {
        super(employeeNo, employeeName, employeeAddress);
        this.title=title;
        //TODO Auto-generated constructor stub
    }
    public QualityAssurance(){

    }    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    // override the toString method
    public String toString(){
        return "Name: "+getEmployeeName()+"NO: "+getEmployeeNo()+" ADDRESS: "+getEmployeeAddress()+"TITLE: "+getTitle();
    }

    
}
