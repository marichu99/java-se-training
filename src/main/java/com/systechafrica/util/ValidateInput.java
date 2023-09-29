package com.systechafrica.util;

import java.util.InputMismatchException;

import com.systechafrica.part3.exceptionhandling.MyCustomExpception;

public class ValidateInput{
    public static final String validate(String input) throws MyCustomExpception{
        if(input!=null && input.length()>0){
            return input;
        }
        throw new MyCustomExpception("Kindly pass in some data");
    }
    public static final int validateInt(int input) throws MyCustomExpception,InputMismatchException{
        if(input < 0){
            throw new MyCustomExpception("Kindly enter a number greater than zero");
        }else if(input %1 !=0){
            throw new InputMismatchException("Kindly enter a number");
        }else{
            return input;
        }
    }
    
}