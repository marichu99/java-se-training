package com.systechafrica.SingleDimensionArrays;

import java.util.logging.Logger;

public class SingleDimensionalArray {
    public static final Logger LOGGER=Logger.getLogger(Logger.class.getName());

    public void singleDimensionalArray(){
        int[] numbers={1,2,3,4,5,6,7,8,9,10};
        String[] nicknames={"marichu","mabera","mato","maati"};
        for(int i=0;i<numbers.length;i++){
            LOGGER.info(""+numbers[i]);
        }
    }
    public static void main(String[] args) {
        SingleDimensionalArray arrClass= new SingleDimensionalArray();
        
        arrClass.singleDimensionalArray();
    }
}
