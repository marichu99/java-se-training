package com.systechafrica.variables;

import java.util.logging.Logger;

import com.systechafrica.App;

public class VariablesDemo{
    private static final Logger LOGGER=Logger.getLogger(App.class.getName());

    //floating types

    public static void main(String[] args){
        VariablesDemo demo = new VariablesDemo();
        int score = 0;
        LOGGER.info("Score integer varale is "+score);
        demo.integertypes();       

    }
    public void integertypes(){
        // constant variable declaration
        final double PI=3.14159;
        LOGGER.info("Constant Variable"+ PI );
        // wrapper classes
        byte aPrimitive =23;
        Byte aWrapper=23;
        LOGGER.info("Byte primitive"+aPrimitive);
        LOGGER.info("Byte wrapper class"+aWrapper);
        LOGGER.info("Integer value from Byte wrapper"+aWrapper.intValue());

        // short 
        short s =23;
        Short sWrapper=23;

    }
    public void floatingtypes(){
        float this_float=2.14521452F;
        LOGGER.info("The floating val is"+this_float);
        LOGGER.info("The maximum float value is");

        float price =0.2356F;
        Float priceWrapper=0.2365F;
    }
}