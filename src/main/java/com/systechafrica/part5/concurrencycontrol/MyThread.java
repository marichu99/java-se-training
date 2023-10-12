package com.systechafrica.part5.concurrencycontrol;

public class MyThread extends Thread{
    private int threadNumber;
    

    public MyThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }


    @Override
    public void run() {
        SynchronizationExample se = new SynchronizationExample();
        se.modifySharedVariable(threadNumber);
        System.out.println("thread "+threadNumber+" is running ");
    }
        
}
