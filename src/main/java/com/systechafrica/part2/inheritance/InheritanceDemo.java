package com.systechafrica.part2.inheritance;

import java.util.logging.Logger;

public class InheritanceDemo{
    public static final Logger LOGGER =Logger.getLogger(InheritanceDemo.class.getName());


    public void companySetup(){
        QualityAssurance qa = new QualityAssurance();
        qa.setEmployeeName("Immah");
        qa.setEmployeeNo(0025);
        qa.setTitle("Quality Assurance Engineer");
        LOGGER.info("QA = >"+qa.toString());

        SoftwareEngineer e1 = new SoftwareEngineer();
        e1.setEmployeeName("Immah");
        e1.setEmployeeNo(0025);
        e1.setTitle("Software Engineer");
        LOGGER.info("SWE = >"+e1.toString());
    }
    public static void main(String[] args){
        InheritanceDemo demo = new InheritanceDemo();

        LOGGER.info("app=>"+demo.hashCode());
        LOGGER.info("app=>"+demo.toString());
        LOGGER.info("app=>"+demo.getClass().getPackageName());
    }
}