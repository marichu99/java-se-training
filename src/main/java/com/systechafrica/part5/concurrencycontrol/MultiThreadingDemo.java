package com.systechafrica.part5.concurrencycontrol;

public class MultiThreadingDemo {
    public static void main(String[] args) {
        MyThread firstThread = new MyThread(1)   ;
        MyThread secondThread = new MyThread(2);
        SecondThread thirdThread= new SecondThread(3);
        SecondThread fourthThread = new SecondThread(4);

        // implementing threads using lambda
        Thread t1= new Thread(()->{
            System.out.print("My new thread is running ");
            System.out.print("Using lambda");
        });

        secondThread.setPriority(Thread.MAX_PRIORITY);
        firstThread.setPriority(Thread.MIN_PRIORITY);
        t1.setPriority(8);
        // thirdThread.setPriority(Thread.NORM_PRIORITY);
        
        try {
            secondThread.sleep(12);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        firstThread.start();
        secondThread.start();
        thirdThread.run();
        fourthThread.run();
        t1.start();
        
    }    
}
