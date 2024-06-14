package com.dvb.practice.sorting;

import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortArrayListSortMethod {

    public static void main(String[] args) {
        Instant start = Instant.now();

        // Sort Ascending
        List<Long> numbersArray = generateNumbersArray();
        System.out.println("Unsorted Numbers: " + numbersArray);

        numbersArray.sort(Comparator.naturalOrder());
        System.out.println("Sorted Numbers In Ascending Order: " + numbersArray);

        // Sort Descending
        numbersArray = generateNumbersArray();
        System.out.println("Unsorted Numbers: " + numbersArray);

        numbersArray.sort(Comparator.reverseOrder());
        System.out.println("Sorted Numbers In Descending Order: " + numbersArray);

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time Elapsed: " + timeElapsed + " milliseconds");
    }

    private static List<Long> generateNumbersArray() {
        return Stream.of(15L, 2L, 5L, 4L, 8L, 11L, 10L, 1L, 7L, 9L, 3L, 6L, 12L, 14L, 13L)
                .collect(Collectors.toList());
    }

}
