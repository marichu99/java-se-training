package com.systechafrica.part5.concurrencycontrol.java8concurrency;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    /*
     * Completable future method provides a way to work with aynchronous tasks such as executing computations in the background and then handling exceptions when they become available
     * it provides a powerful flexible API for for managing aynchronous operations,making it easier to write responsive, efficient and concurrent code
     * You can chain multiple asynchronous operations together using methods like thenApply, thenCompose, thenCombine to create a pipeline of tasks
     */
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            // simulate a time-consuming operation
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                System.out.println("The Exception is "+e.getMessage());
            }
            return 42;
            
        });
        future.thenApply(result-> result*2)
                .thenApply(result-> result/23)
                  .thenAccept(result -> System.out.println(result));
        future.join();
    }
    
}
