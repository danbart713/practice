package com.dvb.practice.binarysearch;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BinarySearchIterative {

    public static void main(String[] args) {
        Instant start = Instant.now();
        
        long[] numbersArray = new long[]{15L, 2L, 5L, 2L, 4L, 8L, 2L, 11L, 8L, 2L, 10L, 1L, 2L, 8L, 7L, 2L, 9L, 8L, 3L, 6L, 12L, 8L, 14L, 13L};
        Arrays.sort(numbersArray);
        System.out.println("Numbers Array: " + Arrays.toString(numbersArray));

        // Equal To
        long equalToNumber = 2L;
        System.out.println("Equal To: 2");
        int[] numbersArrayIndexPositions = binarySearchByCriteria(numbersArray, equalToNumber, null, SearchCriteria.EQUAL_TO);
        System.out.println("Numbers Array Index Position(s): " + Arrays.toString(numbersArrayIndexPositions));

        // Less Than
        long lessThanNumber = 9L;
        System.out.println("Less Than: " + lessThanNumber);
        numbersArrayIndexPositions = binarySearchByCriteria(numbersArray, lessThanNumber, null, SearchCriteria.LESS_THAN);
        System.out.println("Numbers Array Index Position(s): " + Arrays.toString(numbersArrayIndexPositions));

        // Greater Than
        long greaterThanNumber = 9L;
        System.out.println("Greater Than: " + greaterThanNumber);
        numbersArrayIndexPositions = binarySearchByCriteria(numbersArray, greaterThanNumber, null, SearchCriteria.GREATER_THAN);
        System.out.println("Numbers Array Index Position(s): " + Arrays.toString(numbersArrayIndexPositions));

        // Range
        long leftIndexNumber = 2L;
        long rightIndexNumber = 8L;
        System.out.println("Left Index Number: " + leftIndexNumber);
        System.out.println("Right Index Number: " + rightIndexNumber);
        numbersArrayIndexPositions = binarySearchByCriteria(numbersArray, leftIndexNumber, rightIndexNumber, SearchCriteria.RANGE);
        System.out.println("Numbers Array Index Position(s): " + Arrays.toString(numbersArrayIndexPositions));

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time Elapsed: " + timeElapsed + " milliseconds");
    }

    private static int[] binarySearchByCriteria(long[] numbersArray, Long numberToMatchA, Long numberToMatchB, SearchCriteria searchCriteria) {
        return switch (searchCriteria) {
            case EQUAL_TO -> {
                List<Integer> numbersArrayListIndexPositions = binarySearchEqualTo(numbersArray, numberToMatchA);
                yield convertListToArray(numbersArrayListIndexPositions);
            }
            case LESS_THAN -> {
                List<Integer> numbersArrayListIndexPositions = binarySearchLessThan(numbersArray, numberToMatchA);
                numbersArrayListIndexPositions.sort(Comparator.naturalOrder());
                yield convertListToArray(numbersArrayListIndexPositions);
            }
            case GREATER_THAN -> {
                List<Integer> numbersArrayListIndexPositions = binarySearchGreaterThan(numbersArray, numberToMatchA);
                yield convertListToArray(numbersArrayListIndexPositions);
            }
            case RANGE -> {
                int currentIndexLeft = binarySearchRangeLeft(numbersArray, numberToMatchA);
                int currentIndexRight = binarySearchRangeRight(numbersArray, numberToMatchB);
                List<Integer> numbersArrayListIndexPositions = new ArrayList<>();

                for (int i = currentIndexLeft; i <= currentIndexRight; i++) {
                    numbersArrayListIndexPositions.add(i);
                }

                yield convertListToArray(numbersArrayListIndexPositions);
            }
        };
    }

    private static List<Integer> binarySearchEqualTo(long[] numbersArray, Long numberToMatchA) {
        int leftIndex = 0;
        int rightIndex = numbersArray.length - 1;
        int currentIndex;
        List<Integer> numbersArrayListIndexPositions = new ArrayList<>();

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;

            if (numbersArray[middleIndex] == numberToMatchA) {
                currentIndex = middleIndex;

                while (currentIndex > 0 && numbersArray[currentIndex - 1] == numberToMatchA) {
                    currentIndex--;
                }

                while (numbersArray[currentIndex] == numberToMatchA) {
                    numbersArrayListIndexPositions.add(currentIndex++);
                }

                break;
            } else if (numbersArray[middleIndex] > numberToMatchA) {
                rightIndex = middleIndex - 1;
            } else {
                leftIndex = middleIndex + 1;
            }
        }
        return numbersArrayListIndexPositions;
    }

    private static List<Integer> binarySearchLessThan(long[] numbersArray, Long numberToMatchA) {
        int leftIndex = 0;
        int rightIndex = numbersArray.length - 1;
        int currentIndex;
        List<Integer> numbersArrayListIndexPositions = new ArrayList<>();

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;

            if (numbersArray[middleIndex] == numberToMatchA - 1) {
                currentIndex = middleIndex;

                while (currentIndex < numbersArray.length - 1 && numbersArray[currentIndex + 1] < numberToMatchA) {
                    currentIndex++;
                }

                while (currentIndex >= 0) {
                    numbersArrayListIndexPositions.add(currentIndex--);
                }

                break;
            } else if (numbersArray[middleIndex] > numberToMatchA - 1) {
                rightIndex = middleIndex - 1;
            } else {
                leftIndex = middleIndex + 1;
            }
        }
        return numbersArrayListIndexPositions;
    }

    private static List<Integer> binarySearchGreaterThan(long[] numbersArray, Long numberToMatchA) {
        int leftIndex = 0;
        int rightIndex = numbersArray.length - 1;
        int currentIndex;
        List<Integer> numbersArrayListIndexPositions = new ArrayList<>();

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;

            if (numbersArray[middleIndex] == numberToMatchA + 1) {
                currentIndex = middleIndex;

                while (currentIndex > 0 && numbersArray[currentIndex - 1] > numberToMatchA) {
                    currentIndex--;
                }

                while (currentIndex <= numbersArray.length - 1) {
                    numbersArrayListIndexPositions.add(currentIndex++);
                }

                break;
            } else if (numbersArray[middleIndex] > numberToMatchA + 1) {
                rightIndex = middleIndex - 1;
            } else {
                leftIndex = middleIndex + 1;
            }
        }
        return numbersArrayListIndexPositions;
    }

    private static int binarySearchRangeLeft(long[] numbersArray, Long numberToMatchA) {
        int leftIndex = 0;
        int rightIndex = numbersArray.length - 1;
        int currentIndexLeft = 0;

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;

            if (numbersArray[middleIndex] == numberToMatchA) {
                currentIndexLeft = middleIndex;

                while (currentIndexLeft > 0 && numbersArray[currentIndexLeft - 1] == numberToMatchA) {
                    currentIndexLeft--;
                }

                break;
            } else if (numbersArray[middleIndex] > numberToMatchA) {
                rightIndex = middleIndex - 1;
            } else {
                leftIndex = middleIndex + 1;
            }
        }
        return currentIndexLeft;
    }

    private static int binarySearchRangeRight(long[] numbersArray, Long numberToMatchB) {
        int leftIndex = 0;
        int rightIndex = numbersArray.length - 1;
        int currentIndexRight = 0;

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;

            if (numbersArray[middleIndex] == numberToMatchB) {
                currentIndexRight = middleIndex;

                while (currentIndexRight < numbersArray.length - 1 && numbersArray[currentIndexRight + 1] == numberToMatchB) {
                    currentIndexRight++;
                }

                break;
            } else if (numbersArray[middleIndex] > numberToMatchB) {
                rightIndex = middleIndex - 1;
            } else {
                leftIndex = middleIndex + 1;
            }
        }
        return currentIndexRight;
    }

    private static int[] convertListToArray(List<Integer> numbersArrayListIndexPositions) {
        return numbersArrayListIndexPositions.stream()
                .mapToInt(integer -> integer.intValue())
                .toArray();
    }

    enum SearchCriteria {
        EQUAL_TO,
        LESS_THAN,
        GREATER_THAN,
        RANGE
    }

}
