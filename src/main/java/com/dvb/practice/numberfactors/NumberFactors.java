package com.dvb.practice.numberfactors;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

public class NumberFactors {

    public static void main(String[] args) {
        Instant start = Instant.now();

        long numberToFactor = 24;
        System.out.println("Number to Factor: " + numberToFactor);

        Set<Long> factorsSet = calculateAllFactorsOfNumber(numberToFactor);
        System.out.println("Factors of " + numberToFactor + ": " + factorsSet);

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time Elapsed: " + timeElapsed + " milliseconds");
    }

    private static Set<Long> calculateAllFactorsOfNumber(long numberToFactor) {
        Set<Long> factorsSet = new LinkedHashSet<>();

        long increment = numberToFactor % 2L == 0L ? 1L : 2L;

        for (long i = 1L; i <= Math.sqrt(numberToFactor); i += increment) {
            if (numberToFactor % i == 0L) {
                factorsSet.add(i);
                factorsSet.add(numberToFactor / i);
            }
        }

        return factorsSet;
    }

}
