package com.systechafrica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import com.systechafrica.operators.OperatorsDemo;
import com.systechafrica.controlflow.ControlFLow;


@TestInstance(TestInstance.Lifecycle.PER_CLASS) //default instance
public class AppTest 
{
    App app= new App();
    @Test
    void add(){
        int result=app.add(2,3);
        int expected=5;
        Assertions.assertEquals(expected, result,"The sum of 2 and 3 should be 5");        
    }
    OperatorsDemo demo =new OperatorsDemo();
    ControlFLow flow = new ControlFLow();

    void equalTo(){
                
    }

    

   
}
