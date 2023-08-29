package com.systechafrica.stringsandstringbuilders.StringClassDemo;
import java.util.logging.Logger;

public class StringClassDemo{

    public static final  Logger LOGGER= Logger.getLogger(StringClassDemo.class.getName());

    public void createString(){
        String thisString = new String("Mabera");
        thisString.concat("is awesome");

        String sb = new String("Hello, World");
        String sa = "Hello, World";

        LOGGER.info(""+sa.equals(sb));

    }
    public static void main(String[] args){
        StringClassDemo demo = new StringClassDemo();

    }
}