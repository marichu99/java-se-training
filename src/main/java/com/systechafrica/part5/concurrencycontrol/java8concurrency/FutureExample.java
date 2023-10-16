package com.systechafrica.part5.concurrencycontrol.java8concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) {
        // create an ExecutorService to manage the thread(s)
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // use a future that returns a result of the type Integer
        Future<Integer> future = executor.submit(()->{
            // Simulate a time-consuming computation
            Thread.sleep(2000);
            return 43;
        });


        // Perform other tasks while waiting for the computation to complete
        try{
            // block the result when its ready
            Integer result = future.get();
            System.out.println("Computation result: "+result);
        }catch(InterruptedException | ExecutionException e){
            System.out.println("The error message is "+e.getMessage());
        }
        executor.shutdown();
    }    
}
