package com.touraj.guavajava8;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        System.out.println("Project Starting....");
        System.out.println("Project Starting....");
        System.out.println("Project Starting....");
        System.out.println("Project Starting....");
        System.out.println("Project Starting....");
        System.out.println("Project Starting....");
        System.out.println("Project Starting....");


        // Predicates

//        Predicates are boolean-valued functions of one argument.
//        The interface contains various default methods for composing predicates
//        to complex logical terms (and, or, negate)


        Predicate<String> predicate = (s) -> s.length() > 0;

        boolean res = predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        System.out.println(res);

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        // Functions
//        Functions accept one argument and produce a result.
//        Default methods can be used to chain multiple functions together (compose, andThen).

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        int i = toInteger.apply("777");
        System.out.println(i);

        backToString.apply("123");     // "123"

    }

}
