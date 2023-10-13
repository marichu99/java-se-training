package com.systechafrica.part5.concurrencycontrol.java8concurrency;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService  executor = Executors.newScheduledThreadPool(1);
        Runnable task =()->{
            System.out.println("Task executed at"+LocalTime.now());
        };

        executor.scheduleAtFixedRate(task, 1,2, TimeUnit.SECONDS);
    }
    
}
