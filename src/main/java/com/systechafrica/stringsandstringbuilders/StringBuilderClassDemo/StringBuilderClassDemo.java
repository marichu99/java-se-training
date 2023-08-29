package com.systechafrica.stringsandstringbuilders.StringBuilderClassDemo;

import java.util.logging.Logger;

public class StringBuilderClassDemo {
    public static final Logger LOGGER = Logger.getLogger(StringBuilderClassDemo.class.getName());
    
    public static void main(String[] args){

        StringBuilder sb = new StringBuilder(100);
        sb.append(" ");
        String str= " ";

        boolean equalTo= str.equals(sb.toString());
        LOGGER.info(""+equalTo);

    }
}
