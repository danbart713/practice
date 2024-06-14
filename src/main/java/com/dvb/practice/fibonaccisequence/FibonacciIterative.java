package com.dvb.practice.fibonaccisequence;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class FibonacciIterative {

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
        long currentNumber = 0L;
        long nextNumber = 1L;

        for (int i = 0; i < numberOfIterations; i++) {
            fibonacciSequenceList.add(currentNumber);

            long tempNumber = currentNumber + nextNumber;
            currentNumber = nextNumber;
            nextNumber = tempNumber;
        }

        System.out.println("Fibonacci Sequence Iterative Array: " + fibonacciSequenceList);
    }

}
