package com.touraj.guavajava8;

public class Main2 {

    public static void main(String[] args) {

        System.out.println("Main 2....");
        System.out.println("Main 2....");

        System.out.println(process("fffffff"));
        System.out.println(process(1111));

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
