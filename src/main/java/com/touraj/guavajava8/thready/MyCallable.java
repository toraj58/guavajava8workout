package com.touraj.guavajava8.thready;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {

        try {
            TimeUnit.SECONDS.sleep(5);
            return "Touraj";
        }  catch (InterruptedException e) {
            throw new IllegalStateException("task interrupted", e);
        }
    }
}
