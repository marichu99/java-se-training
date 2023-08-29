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
    public void whileLoop(){
        int counter=0;
        while(counter<=10){
            LOGGER.info("The counter value is"+counter);
        }
    }
    public void doWhile(){
        int counter=0;
        do{
            LOGGER.info("The counter value is "+counter);
            counter++;
        }while(counter<=10);
    }
    public void breakJumpstatements(){
        for(int i=0;i<10;i++){
            if(i == 5){
                break;
            }
            LOGGER.info("Index is"+i);
        }
    }

    public void continueJumpStatements(){
        for(int i=0;i<10;i++){
            if(i == 5){
                continue;
            }
            LOGGER.info("Index is"+i);
        }
    }
    public void returnJumpStatements(){
        for(int i=0;i<10;i++){
            if(i == 5){
                return;
            }
            LOGGER.info("Index is"+i);
        }
    }
    public int search( int numberToSearch){
        for(int i=0;i<50;i++){
            if(i == numberToSearch){
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        LoopingStatements app = new LoopingStatements();
        // app.breakJumpstatements();
        // app.continueJumpStatements();
        app.returnJumpStatements();
    }
}
