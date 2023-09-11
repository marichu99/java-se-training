package com.systechafrica.part2.inheritance;

public class SoftwareEngineer extends Employee{
    public SoftwareEngineer(int employeeNo, String employeeName, String employeeAddress) {
        super(employeeNo, employeeName, employeeAddress);
        //TODO Auto-generated constructor stub
    }
    public SoftwareEngineer(){
        
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }    
}
