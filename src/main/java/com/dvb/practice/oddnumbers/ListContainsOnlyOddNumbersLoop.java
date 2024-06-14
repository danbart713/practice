package com.dvb.practice.oddnumbers;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListContainsOnlyOddNumbersLoop {

    public static void main(String[] args) {
        Instant start = Instant.now();

        List<Long> numbersList = Stream.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L, 15L)
                .collect(Collectors.toList());
        System.out.println("List of Numbers: " + numbersList);

        boolean listContainsOnlyOddNumbers = checkIfListContainsOnlyOddNumbers(numbersList);
        System.out.println("List Contains Only Odd Numbers: " + listContainsOnlyOddNumbers);

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time Elapsed: " + timeElapsed + " milliseconds");
    }

    private static boolean checkIfListContainsOnlyOddNumbers(List<Long> numbersList) {
        for (Long number : numbersList) {
            if (number % 2 == 0) {
                return false;
            }
        }
        return true;
    }

}
