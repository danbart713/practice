package com.dvb.practice.sorting;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortArraySortMethod {

    public static void main(String[] args) {
        Instant start = Instant.now();

        long[] numbersArray = new long[]{15L, 2L, 5L, 4L, 8L, 11L, 10L, 1L, 7L, 9L, 3L, 6L, 12L, 14L, 13L};
        System.out.println("Unsorted Numbers: " + Arrays.toString(numbersArray));

        Arrays.sort(numbersArray);
        System.out.println("Sorted Numbers: " + Arrays.toString(numbersArray));

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time Elapsed: " + timeElapsed + " milliseconds");
    }

}
