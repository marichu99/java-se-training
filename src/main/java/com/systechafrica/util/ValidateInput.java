package com.systechafrica.util;

public class ValidateInput{
    public static final String validate(String input){
        if(input!=null && input.length()>0){
            return "valid ";
        }
        return "invalid ";
    }
}