package com.systechafrica.part5.concurrencycontrol;

public class SecondThread implements Runnable{

    private final int threadNumber;
    
    public SecondThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        System.out.println("thread "+threadNumber+" is running "); 
    }        
}
