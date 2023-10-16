package com.systechafrica.part5.stack;

public class Stack {
    private final int[] items;
    
    private int topOfStack;
    private final Object lock;
    public Stack(int capacity){
        this.items=new int[capacity];
        topOfStack=-1;
        lock = new Object();
    }

    public synchronized boolean push(int item){
        // check if the stack is full
        if(isFull()){
            return false;
        }

        // increment top of the stack
        topOfStack=topOfStack+1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // assign
        items[topOfStack]=item;
        return true;
    }
     public synchronized int pop(){
        // check if the stack is full
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        
        // GET THE ITEM at the top of the stack
        int item = items[topOfStack];

        // reset item at the top of the stack
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        items[topOfStack]=Integer.MIN_VALUE;
        topOfStack=topOfStack-1;
        return item;
    }
    private boolean isEmpty(){
        return topOfStack <0;
    }
    private boolean isFull(){
        return topOfStack == items.length-1;
    }
    
}
