package com.effectivejava.items.item6;

public class Primitives {

    private static long sum() {
        long sum = 0L;//dont use Long. Autoboxing mixes primitive and
        //boxed primitives.If Long is used. every time the iteration runs a new Long object is created
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}
