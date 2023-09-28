package com.systechafrica.part3.collection;

import java.util.LinkedList;
import java.util.Queue;

public class WorkingWithQueues {
    public static void main(String[] args) {
        workingWithQueues();
    }
    public static void workingWithQueues(){
        Queue<PrintJob> queue = new LinkedList<>();
        queue.add(new PrintJob("Articles"));
        queue.add(new PrintJob("Journal")); // throws a runtime exception when not possible to add the book
        queue.add(new PrintJob("book"));

        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.peek());

    }
    
}

