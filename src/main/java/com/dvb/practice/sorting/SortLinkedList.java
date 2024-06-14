package com.dvb.practice.sorting;

import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortLinkedList {

    public static void main(String[] args) {
        Instant start = Instant.now();

        // Sort Ascending
        LinkedList<Long> numbersLinkedList = generateNumbersArray();
        System.out.println("Unsorted Numbers: " + numbersLinkedList);

        LinkedList<Long> numbersLinkedListSorted = sortLinkedList(numbersLinkedList, SortMethod.ASCENDING);
        System.out.println("Sorted Numbers In Ascending Order: " + numbersLinkedListSorted);

        // Sort Descending
        numbersLinkedList = generateNumbersArray();
        System.out.println("Unsorted Numbers: " + numbersLinkedList);

        numbersLinkedListSorted = sortLinkedList(numbersLinkedList, SortMethod.DESCENDING);
        System.out.println("Sorted Numbers In Descending Order: " + numbersLinkedListSorted);

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time Elapsed: " + timeElapsed + " milliseconds");
    }

    private static LinkedList<Long> generateNumbersArray() {
        return Stream.of(15L, 2L, 5L, 4L, 8L, 11L, 10L, 1L, 7L, 9L, 3L, 6L, 12L, 14L, 13L)
                .collect(Collectors.toCollection(() -> new LinkedList<>()));
    }

    private static LinkedList<Long> sortLinkedList(LinkedList<Long> numbersLinkedList, SortMethod sortMethod) {
        return switch (sortMethod) {
            case ASCENDING -> numbersLinkedList.stream()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.toCollection(() -> new LinkedList<>()));
            case DESCENDING -> numbersLinkedList.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toCollection(() -> new LinkedList<>()));
        };
    }

    enum SortMethod {
        ASCENDING, DESCENDING;
    }

}
