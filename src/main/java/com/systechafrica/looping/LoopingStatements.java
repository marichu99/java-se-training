package com.systechafrica.looping;

import java.util.logging.Logger;

public class LoopingStatements {
    public static final Logger LOGGER =Logger.getLogger(LoopingStatements.class.getName());

    public void forLoop(){
        
        // initilization
        for(int counter =0;counter<10;counter++){
            LOGGER.info("The counter value"+counter);
        }
    }
    public static void main(String[] args){
        LoopingStatements app = new LoopingStatements();

    }
}
