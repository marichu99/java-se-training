package com.systechafrica.part5.concurrencycontrol.java8concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
    public static void main(String[] args) {
        
        ExecutorService service = Executors.newSingleThreadExecutor();
        System.out.println("Before submitting the task "+LocalDateTime.now());
        Future<Integer> submit = service.submit(()->{
            Thread.sleep(5000);
            return 8;
        });
        System.out.println("After task submission"+LocalDateTime.now());
    }
    
}
