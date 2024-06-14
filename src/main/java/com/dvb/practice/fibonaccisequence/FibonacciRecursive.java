package com.dvb.practice.fibonaccisequence;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class FibonacciRecursive {

    public static void main(String[] args) {
        Instant start = Instant.now();

        int numberOfIterations = 45;
        generateFibonacciSequence(numberOfIterations);

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time Elapsed: " + timeElapsed + " milliseconds");
    }

    private static void generateFibonacciSequence(int numberOfIterations) {
        List<Long> fibonacciSequenceList = new ArrayList<>();

        for (int i = 0; i < numberOfIterations; i++) {
            fibonacciSequenceList.add(doGenerateFibonacciSequence(i));
        }

        System.out.println("Fibonacci Sequence Recursive Array: " + fibonacciSequenceList);
    }

    private static long doGenerateFibonacciSequence(int i) {
        if (i <= 1) {
            return i;
        } else {
            return doGenerateFibonacciSequence(i - 1) + doGenerateFibonacciSequence(i - 2);
        }
    }

}
