package com.touraj.guavajava8;

import java.util.function.Function;

public class Temp {

    private String method(String input) {

        System.out.println(genericMethod(input, in -> input.replace("a","$")));
        return genericMethod(input, in -> input.replace("a","$"));
    }

    private byte[] method(byte[] value) {
        return genericMethod(value, input -> value);
    }

    private <T> T genericMethod(T param1, Function<T, T> function) {
        try {
            return function.apply(param1);
        } catch (Throwable t) {

            return param1;
        }
    }
}
