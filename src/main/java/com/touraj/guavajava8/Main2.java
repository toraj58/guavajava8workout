package com.touraj.guavajava8;

import com.touraj.guavajava8.thready.CallableTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Main 2....");

        System.out.println(process("Process"));
        System.out.println(process(1000));

        CallableTask callableTask = new CallableTask("Touraj");

        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<String>> futures = new ArrayList<>();

        for (int i = 1; i <=10 ; i++) {

//            Future<String> future = executor.submit(new CallableTask("Touraj" + i));
            Future<String> future = executor.submit(callableTask);
            futures.add(future);

        }

        // Shutting Down Executor
        executor.shutdown();

        for (Future<String> future : futures) {

            System.out.println("Future Value is :: "+ future.get());
        }

        System.out.println("Process Ended ...");

        List<String> strings = new ArrayList<>();

        List<String> stringList = new ArrayList<>();
        stringList.add("Metric1");
        stringList.add("Metric2");
        stringList.add("Metric3");

        stringList.stream().forEach((s)-> aggregateMethod(s,1, strings));

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void aggregateMethod(String name, int val, List<String> strings) {

        System.out.println("Output ::" + name + val);
        strings.add(name+val);
    }

    private static <T> T process(T val) {

        String test = "test";
        if (val instanceof String) {

            String v = ((String) val).replace("f", "$");
            return (T) v;
        }
        return val;
    }

    // new line 1 in morejava8 branch
}
