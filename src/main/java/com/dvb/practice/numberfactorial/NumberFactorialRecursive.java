package com.dvb.practice.numberfactorial;

import java.time.Duration;
import java.time.Instant;

public class NumberFactorialRecursive {

    public static void main(String[] args) {
        Instant start = Instant.now();

        long number = 18;
        System.out.println("Number To Factor: " + number);

        long numberFactorial = factorNumber(number);
        System.out.println("Factored Number: " + numberFactorial);

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time Elapsed: " + timeElapsed + " milliseconds");
    }

    private static long factorNumber(long number) {
        if (number == 1L) {
            System.out.println(1L);
            return 1L;
        } else {
            long numberFactorial = number * factorNumber(number - 1);
            System.out.println(numberFactorial);
            return numberFactorial;
        }
    }

}
