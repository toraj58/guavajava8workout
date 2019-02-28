package com.touraj.guavajava8.thready;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {

    private String name;

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {

        int res = new Random().nextInt();

        return name + "::" + res;
    }
}
