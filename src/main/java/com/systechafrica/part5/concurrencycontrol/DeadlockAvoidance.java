package com.systechafrica.part5.concurrencycontrol;

public class DeadlockAvoidance {
    private final Object lock1 = new Object();
    private final Object lock2= new Object();
    
    public void performTask1(){
        synchronized(lock1){
            synchronized(lock2){
                System.out.println("Inside the perform task 1");
            }
        }
    }
    public void performTask2(){
        
    }
}
