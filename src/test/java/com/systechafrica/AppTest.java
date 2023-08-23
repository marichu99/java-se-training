package com.systechafrica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS) //default instance
public class AppTest 
{
    App app = new App();
   @Test
   void add(){
        // when 
        int result= app.add(2,3);
        int expected =5;
        // verify 
        Assertions.assertEquals(expected,result,"the sum of 2+3 should be 5");

   }
}
