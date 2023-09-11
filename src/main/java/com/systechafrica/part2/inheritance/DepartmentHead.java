package com.systechafrica.part2.inheritance;

public class DepartmentHead extends Employee{
    public DepartmentHead(int employeeNo, String employeeName, String employeeAddress) {
        super(employeeNo, employeeName, employeeAddress);
        //TODO Auto-generated constructor stub
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
