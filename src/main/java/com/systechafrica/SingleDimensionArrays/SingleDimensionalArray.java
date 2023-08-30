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
    public void multiDimensionalArray(){
        int [][] matrix={{1,2,3},{4,5,6},{7,8,9}};

        for(int i=0;i<matrix.length;i++){
            for( int j=0;j<matrix[i].length;j++){
                LOGGER.info(""+matrix[i][j]);
            }
        }
    }
    public static void main(String[] args) {
        SingleDimensionalArray arrClass= new SingleDimensionalArray();
        
        // arrClass.singleDimensionalArray();
        arrClass.multiDimensionalArray();
    }
}
