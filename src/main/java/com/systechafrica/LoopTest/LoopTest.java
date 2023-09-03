package com.systechafrica.LoopTest;

import java.util.Scanner;
import java.util.logging.Logger;

public class LoopTest {
    public static final Logger LOGGER= Logger.getLogger(LoopTest.class.getName());
    public void loopExercise(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter the number to iterate: ");
        int inputNo= myScanner.nextInt();
        int iterator=((inputNo)*2);
        int shifterVarFront=2;
        int shifterVarBack=iterator;
        int changeInput=inputNo;
        for(int i=1;i<=iterator;i++){
            for(int j=1;j<=iterator;j++){
                if(j==iterator){
                    System.out.println(" ");
                    if(i>1){
                        shifterVarBack--;
                        shifterVarFront++;
                        changeInput--;
                    }                    
                }else{
                    if(i==shifterVarFront ){
                        if(j >= shifterVarFront &&j<shifterVarBack-1){
                            int newInput=changeInput-1;
                            System.out.print(newInput+" ");
                        }else{
                            System.out.print(inputNo+" ");
                        }
                    }else{
                        System.out.print(inputNo+" ");
                    }
                    
                }
            }
        }
        myScanner.close();
    }
    public static void main(String[] args) {
        LoopTest app= new LoopTest();
        app.loopExercise();
    }
    
}
