package com.touraj.guavajava8.thready;

import java.util.concurrent.*;

public class SimpleFuture2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("SIM Future ....");
        System.out.println("SIM Future ....");
        System.out.println("SIM Future ....");
        System.out.println("SIM Future ....");

        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(task);
        Future<String> future2 = executor.submit(new MyCallable());

        System.out.println("future done? " + future.isDone());

        Integer result = future.get();
        System.out.println("result: " + result);
        System.out.println("future done? " + future.isDone());
        System.out.println("ddone...");
        String result2 = future2.get();

        System.out.println("result2: " + result2);

        executor.shutdown();

    }

}
