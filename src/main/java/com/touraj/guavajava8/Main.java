package com.touraj.guavajava8;

import com.touraj.guavajava8.model.Car;
import com.touraj.guavajava8.model.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

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

        List<String> stringList = Arrays.asList("t", "a", "b", "a");
        List<Double> doubleList = Arrays.asList(1.2, 2.3333, 4.5, 7.0, 0.0, 0.0);

        long a = stringList.stream().filter(s -> s.equals("a")).count();
        long b = doubleList.stream().filter(d -> d > 4).count();

        Stream<String> z = stringList.stream().filter(s -> s.equals("t"));
        z.forEach(System.out::println);
        System.out.println("Res >> :: " + a);
        System.out.println("Res b>> :: " + b);


        Predicate<String> predicate = (s) -> s.length() > 0;

        boolean res = predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        System.out.println(res);

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        // More Game with Predicates:

        List<String> all = Arrays.asList("t1", "t2", "t3", "tttt", "wersdf");
        all.stream().forEach(System.out::println);
        System.out.println("Do filter...");
        all.stream().filter((s) -> s.length() > 3).forEach(System.out::println);

        Predicate<String> pre = (s) -> s.length() > 5;
        System.out.println("Filter with Predicate...");

        all.stream().filter(pre.negate()).forEach(System.out::println);

        // Functions
//        Functions accept one argument and produce a result.
//        Default methods can be used to chain multiple functions together (compose, andThen).

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        Function<String, String> newFunc = (s) -> s.replace("d", "$");
        String data = newFunc.apply("data");
        System.out.println(">>>>>>>>>>>>>>>>data ::" + data);

        int i = toInteger.apply("777");
        System.out.println(i);

        backToString.apply("123");     // "123"

//        Suppliers#

//        Suppliers produce a result of a given generic type.
//        Unlike Functions, Suppliers don't accept arguments.

        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // new Person

//        Consumers#

//        Consumers represents operations to be performed on a single input argument.

        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getName());
        greeter.accept(new Person("Luke", "Skywalker", new Car("toyota", "2000")));


//        Comparators#

//        Comparators are well known from older versions of Java. Java 8 adds various default methods to the interface.

        Comparator<Person> comparator = (p1, p2) -> p1.getName().compareTo(p2.getName());

        Person p1 = new Person("John", "Doe", new Car("toyota", "2000"));
        Person p2 = new Person("Alice", "Wonderland", new Car("toyota", "2000"));

        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0

    }

}
