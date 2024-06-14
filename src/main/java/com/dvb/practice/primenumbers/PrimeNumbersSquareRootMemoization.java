package com.dvb.practice.primenumbers;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class PrimeNumbersSquareRootMemoization {

    private static Map<Long, Boolean> memoizationMap = new HashMap<>();

    public static void main(String[] args) {
        Instant start = Instant.now();

        long[] knownPrimeNumbersArray = generateKnownPrimeNumbersArray();
        long[] knownPrimeNumbers2Array = generateKnownPrimeNumbersArray();
        long[] otherNumbersArray = generateOtherNumbersArray();
        long[] otherNumbers2Array = generateOtherNumbersArray();
        long[][] totalNumbersArray = new long[][]{knownPrimeNumbersArray, knownPrimeNumbers2Array, otherNumbersArray, otherNumbers2Array};

        for (int i = 0; i < totalNumbersArray.length; i++) {
            for (int j = 0; j < totalNumbersArray[i].length; j++) {
                System.out.println("Input Number: " + totalNumbersArray[i][j]);
                boolean primeNumber = checkIfNumberIsPrime(totalNumbersArray[i][j]);
                System.out.println("Input Number Is Prime: " + primeNumber);
            }
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time Elapsed: " + timeElapsed + " milliseconds");
    }

    private static long[] generateKnownPrimeNumbersArray() {
        return new long[]{2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L,
                53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L, 101L, 103L, 107L, 109L, 113L, 127L, 131L, 137L, 139L, 149L,
                151L, 157L, 163L, 167L, 173L, 179L, 181L, 191L, 193L, 197L, 199L, 211L, 223L, 227L, 229L, 233L, 239L, 241L,
                251L, 257L, 263L, 269L, 271L, 277L, 281L, 283L, 293L};
    }

    private static long[] generateOtherNumbersArray() {
        return new long[]{4L, 6L, 8L, 10L, 12L, 14L, 16L, 18L, 20L};
    }

    private static boolean checkIfNumberIsPrime(long inputNumber) {
        if (memoizationMap.containsKey(inputNumber)) {
            System.out.println("Already in memoization map.");
            return memoizationMap.get(inputNumber);
        }

        if (inputNumber <= 1L) {
            memoizationMap.put(inputNumber, false);
            return false;
        }

        if (inputNumber == 2L || inputNumber == 3L) {
            memoizationMap.put(inputNumber, true);
            return true;
        }

        if (inputNumber % 2L == 0L || inputNumber % 3L == 0L) {
            memoizationMap.put(inputNumber, false);
            return false;
        }

        for (long i = 5L; i <= Math.sqrt(inputNumber); i = i + 6L) {
            if (inputNumber % i == 0L || inputNumber % (i + 2L) == 0L) {
                memoizationMap.put(inputNumber, false);
                return false;
            }
        }

        memoizationMap.put(inputNumber, true);
        return true;
    }

}