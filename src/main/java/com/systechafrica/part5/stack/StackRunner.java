package com.systechafrica.part5.stack;

public class StackRunner {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "is running");

        Stack stack = new Stack(5);

        Runnable threadOneLoginc= ()->{
            int counter =0;
            while(++counter<10){
                System.out.println(stack.push(100)+" pushed");
            }
        };
        Runnable threadTwoLoginc= ()->{
            int counter =0;
            while(++counter<10){
                System.out.println(stack.pop()+" popped");
            }
        };

        Thread threadOne = new Thread(threadOneLoginc,"pusher");
        Thread threadTwo = new Thread(threadTwoLoginc,"pooper");
        threadOne.start();
        threadTwo.start();
        System.out.println(Thread.currentThread().getName() +" is running");
    }
    
}
