package com.touraj.guavajava8.model;

public class Person {

    String name;
    String last;

    Car car;

    public Person(String name, String last, Car car) {
        this.name = name;
        this.last = last;
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", last='" + last + '\'' +
                ", car=" + car +
                '}';
    }
// added to person
}
