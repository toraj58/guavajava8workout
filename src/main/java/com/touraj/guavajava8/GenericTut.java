package com.touraj.guavajava8;

import java.util.ArrayList;
import java.util.List;

public class GenericTut {


    public static void main(String[] args) {
        System.out.println("Started server generic...");
        System.out.println("Started server generic...");
        System.out.println("Started server generic...");

        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println("Array integerArray contains:");
        printArray(intArray);   // pass an Integer array

        System.out.println("\nArray doubleArray contains:");
        GenericTut.<Double>printArray(doubleArray);   // pass a Double array

        System.out.println("\nArray characterArray contains:");
        printArray(charArray);   // pass a Character array

        System.out.println("--------------------");

        System.out.printf("Max of %d, %d and %d is %d\n\n",
                3, 4, 5, maximum( 3, 4, 5 ));

        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ));

        System.out.printf("Max of %s, %s and %s is %s\n","pear",
                "apple", "orange", maximum("pear", "apple", "orange"));


        System.out.println("+++++++++++++++++++++");
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(new Integer(10));
        stringBox.add(new String("Hello World"));

        System.out.printf("Integer Value :%d\n\n", integerBox.get());
        System.out.printf("String Value :%s\n", stringBox.get());

        System.out.println("******************************");

        List<Integer> ints = new ArrayList<>();
        ints.add(3); ints.add(5); ints.add(10);
        double sum = sum(ints);
        System.out.println("Sum of ints="+sum);

        System.out.println("<><><><><><><><><><><><><><>");

        List<Number> integers = new ArrayList<>();
        //or
//        List<Integer> integers = new ArrayList<>();
        addIntegers(integers);

    }


    public static < E > void printArray( E[] inputArray ) {
        // Display array elements
        for(E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }


    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;   // assume x is initially the largest

        if(y.compareTo(max) > 0) {
            max = y;   // y is the largest so far
        }

        if(z.compareTo(max) > 0) {
            max = z;   // z is the largest now
        }
        return max;   // returns the largest object
    }


    public static double sum(List<? extends Number> list){
        double sum = 0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void addIntegers(List<? super Integer> list){
        list.add(new Integer(50));

        for (Object o: list
             ) {
            System.out.println(o);

        }
    }


    public static class Box<T> {
        private T t;

        public void add(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }


    }


}
