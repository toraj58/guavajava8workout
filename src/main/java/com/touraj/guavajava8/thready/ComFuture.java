package com.touraj.guavajava8.thready;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ComFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Completable Future ....");
        System.out.println("Completable Future ....");
        System.out.println("Completable Future ....");
        System.out.println("Completable Future ....");

        CompletableFuture<String> future
                = CompletableFuture.supplyAsync(() -> "MongoDB");

        CompletableFuture<Void> futureRun
                = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running");}).thenRun(() -> System.out.println("Process Done!"));

        System.out.println("Before Run Async");

//        futureRun.get();

        System.out.println("After Run Async");

        System.out.println(future.get());

        TimeUnit.SECONDS.sleep(10);

    }

}
