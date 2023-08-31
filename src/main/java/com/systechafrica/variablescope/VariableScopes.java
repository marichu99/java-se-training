package com.systechafrica.variablescope;

import java.util.logging.Logger;

public class VariableScopes{
    private static final Logger LOGGER=Logger.getLogger(VariableScopes.class.getName());
    int no_matches=45;
    // class variables are defined as variables defined outside any class methods
    public void simpleMethod(){
        LOGGER.info("Matches played"+no_matches);
    }
    public int addTwoNumbers(int a , int b){
        return a+b;
    }
    public static void main(String[] args){
        VariableScopes app = new VariableScopes();
        app.addTwoNumbers(7, 8);
    }
}


