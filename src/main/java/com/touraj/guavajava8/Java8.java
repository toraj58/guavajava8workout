package com.touraj.guavajava8;


import java.util.Optional;

public class Java8 {

    public static void main(String[] args) {

        System.out.println("Java 8 features.....");

     /*   Optionals#

        Optionals are not functional interfaces, instead it's a nifty utility to prevent NullPointerException. It's an important concept for the next section, so let's have a quick look at how Optionals work.

        Optional is a simple container for a value which may be null or non-null. Think of a method which may return a non-null result but sometimes return nothing. Instead of returning null you return an Optional in Java 8.
*/
        Optional<String> optional = Optional.of("bam");

        boolean b =  optional.isPresent();           // true
        System.out.println(b);
        String ss =  optional.get();                 // "bam"
        System.out.println(ss);
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> {System.out.println(s.charAt(0));
            System.out.println(s.charAt(1));
            System.out.println("All");
            char[] ca = s.toCharArray();
            for (int i = 0; i <ca.length ; i++) {
                System.out.println("char :: " + ca[i]);
            }
        });     // "b"

    }
}