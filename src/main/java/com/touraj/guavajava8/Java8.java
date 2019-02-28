package com.touraj.guavajava8;


import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


        // Map Example

        List<String> alpha = Arrays.asList("a", "b", "c", "d");

        //Before Java8
        List<String> alphaUpper = new ArrayList<>();
        for (String s : alpha) {
            alphaUpper.add(s.toUpperCase());
        }

        System.out.println(alpha); //[a, b, c, d]
        System.out.println(alphaUpper); //[A, B, C, D]

        // Java 8
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect); //[A, B, C, D]

        // Extra, streams apply to any data type.
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(collect1); //[2, 4, 6, 8, 10]


        System.out.println("________Spliterator______");

        String[] stream = {"one", "two", "three", "four"};

        Spliterator<String> s1 = Stream.of(stream).spliterator();
        Spliterator<String> s2 = s1.trySplit();
        Spliterator<String> s3 = s1.trySplit();
        System.out.println("-- first Spliterator --");
        s1.forEachRemaining(System.out::println);
        System.out.println("-- second Spliterator --");
        s2.forEachRemaining(System.out::println);
        System.out.println("-- Third Spliterator --");
        s3.forEachRemaining(System.out::println);

        System.out.println("------------------------- BiFunction -------------------------");

        BiFunction<String, String, String> biFunction1 = (ss1, ss2) -> ss1 + " :: " + ss2 ;
        BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> biFunction2 = (l, p) -> {
            List<Integer> integers = new ArrayList<>();
            for (Integer integer : l) {
                if (p.test(integer))
                {
                    integers.add(integer);
                }
            }
            return integers;
        } ;

        List<Integer> integersList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Predicate<Integer> integerPredicate = integer -> integer % 2 == 0;

        List<Integer> filteredList = biFunction2.apply(integersList, integerPredicate);

        for (Integer integer : filteredList) {
            System.out.println("List :: " + integer);
        }

        System.out.println(biFunction1.apply("Hello", "Touraj"));

    }
}