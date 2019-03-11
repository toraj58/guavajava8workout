package com.touraj.guavajava8.thready;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ComFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Completable Future ....");

        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "MongoDB");

        CompletableFuture<Void> futureRun
                = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("inside futureRun runAsync.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running");}).thenRun(() -> System.out.println("Process Done!"));

        System.out.println("Before Run Async");

//        futureRun.get();

        System.out.println("After Run Async");
        System.out.println(completableFuture.get());
        TimeUnit.SECONDS.sleep(10);

        CompletableFuture<Void> futureRun2
                = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("inside futureRun runAsync....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running");
            return " :: hey you";
        }).thenAccept((e) -> System.out.println("Process Done!"+ e));

        while (!futureRun2.isDone()) {
        }
    }
}