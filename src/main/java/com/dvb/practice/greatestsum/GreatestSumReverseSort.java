package com.dvb.practice.greatestsum;

import java.util.Arrays;
import java.util.Comparator;

public class GreatestSumReverseSort {

    public static void main(String[] args) {
        int[] numbersArray = {5, 10, 15, 7, 113, 5, 1};
        numbersArray = Arrays.stream(numbersArray)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(integer -> integer.intValue())
                .toArray();
        System.out.println("Numbers Array: " + Arrays.toString(numbersArray));

        int greatestSum = calculateGreatestSum(numbersArray);
        System.out.println("Greatest Sum: " + greatestSum);
    }

    private static int calculateGreatestSum(int[] numbersArray) {
        return numbersArray[0] + numbersArray[1];
    }

}
