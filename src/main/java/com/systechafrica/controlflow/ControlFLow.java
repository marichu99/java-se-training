package com.systechafrica.controlflow;


import com.systechafrica.operators.OperatorsDemo;
import java.util.logging.Logger;

public class ControlFLow{
    public static final Logger LOGGER = Logger.getLogger(ControlFLow.class.getName());

    public void ifElseStatement(){

    }
    public String switchStatement(String day){
        

        switch(day){
            case "MONDAY":
                LOGGER.info("Monday");
                break;
            case "TUESDAY":
                LOGGER.info("TUESDAY");;
                break;
            case "WEDNESDAY":
                LOGGER.info("Wednesday");;
                break;
            case "THURSDAY":
                LOGGER.info("Friday");;
                break;
            case "FRIDAY":
                LOGGER.info("Saturday");;
                break;
            case "SATURDAY":
            case "SUNDAY":
                LOGGER.info("FUN !!!");;
                break;
        }
        return day;
    }
    public static void main(String[] args){
        ControlFLow app = new ControlFLow();
        app.switchStatement("SATURDAY");
    }
}