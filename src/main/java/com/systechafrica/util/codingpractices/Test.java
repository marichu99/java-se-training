package com.systechafrica.util.codingpractices;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class X{
    public void printFileContent(){
        // throw new IOException();
    }
}
public class Test {
    public void dateQuestion(){
        String date=LocalDate.parse("2015-05-04").format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(date);
    }

    public static void main(String[] args) {
        Test app = new Test();
        X xobj= new X();
        try{
            xobj.printFileContent();
        }catch(Exception e){}
        app.dateQuestion();
    }
    
}
