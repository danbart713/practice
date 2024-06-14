package com.dvb.practice.fibonaccisequence;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciRecursiveMemoization {

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
        long[] memoizationIntArray = new long[numberOfIterations + 1];

        for (int i = 0; i < numberOfIterations; i++) {
            fibonacciSequenceList.add(doGenerateFibonacciSequence(i, memoizationIntArray));
        }

        System.out.println("Fibonacci Sequence Memoization Array: " + fibonacciSequenceList);
    }

    private static long doGenerateFibonacciSequence(int i, long[] memoizationIntArray) {
        if (memoizationIntArray[i] != 0L) {
            return memoizationIntArray[i];
        }

        if (i <= 1) {
            return i;
        } else {
            memoizationIntArray[i] = doGenerateFibonacciSequence(i - 1, memoizationIntArray)
                    + doGenerateFibonacciSequence(i - 2, memoizationIntArray);
            return memoizationIntArray[i];
        }
    }

}
