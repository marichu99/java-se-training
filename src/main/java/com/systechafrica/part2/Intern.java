package com.systechafrica.part2;

import java.util.logging.Logger;

public class Intern {
    String name;
    String email;
    String phoneNumber;
    public static final Logger LOGGER=Logger.getLogger(Intern.class.getName());
    public Intern(String name, String email, String phoneNumber){
        this.name=name;
        this.name=email;
        this.phoneNumber=phoneNumber;
    }
    void doAssignment(){
        LOGGER.info(name+"Does assignment");
    }
    void attendClass(){
        LOGGER.info(name+"always attends class");
    }
}
