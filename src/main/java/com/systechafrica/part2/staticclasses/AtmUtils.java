package com.systechafrica.part2.staticclasses;

public class AtmUtils {
    
    public static String maskCardNumber(String cardNo){
        String mask = "XXXXXXXXXXXX";
        String masked = cardNo.substring(12, cardNo.length());
        return mask+masked;
    }
}
