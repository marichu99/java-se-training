package com.systechafrica.util;

import com.systechafrica.part3.exceptionhandling.MyCustomExpception;

public class ValidateInput{
    public static final String validate(String input) throws MyCustomExpception{
        if(input!=null && input.length()>0){
            return "valid";
        }
        throw new MyCustomExpception("Kindly pass in some data");
    }
    public static final void validateInt(int input) throws MyCustomExpception{
        if(input < 0){
            throw new MyCustomExpception("Kindly enter a number greater than zero");
        }
    }
    
}