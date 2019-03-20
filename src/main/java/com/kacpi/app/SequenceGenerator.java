package com.kacpi.app;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author Kacper Staszek
 */
class SequenceGenerator {
    public static void main(String[] args) {

        Set<Seq> sekwencje = new HashSet<>();
        int dł = 5;

        IntStream.iterate(1, i -> (i<dł+1), i -> i + 1).forEach(i ->
            sekwencje.add(new Seq(i, i+dł, i+2*dł))
        );

        System.out.println(sekwencje);
    }
}


/*

1 2 3
4 5 6
7 8 9

123 456 789

 */

class Seq {
    String nazwa;

    Seq(int a, int b, int c) {
        nazwa = String.format("%d_%d_%d", a,b,c);
    }
    @Override
    public String toString() {
        return nazwa;
    }
}