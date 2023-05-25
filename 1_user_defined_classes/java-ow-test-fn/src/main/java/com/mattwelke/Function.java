package com.mattwelke;

public class Function {

    public record Event(String name, int age) {
    }

    public void invoke(Event event) {
        System.out.println("Invoked Function with Event: " + event);
    }
}
