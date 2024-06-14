package com.dvb.practice.greatestsum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class GreatestSumLoop {

    public static void main(String[] args) {
        int[] numbersArray = {5, 10, 15, 7, 113, 5, 1};
        Arrays.sort(numbersArray);
        System.out.println("Numbers Array: " + Arrays.toString(numbersArray));

        int greatestSum = calculateGreatestSum(numbersArray);
        System.out.println("Greatest Sum: " + greatestSum);
    }

    private static int calculateGreatestSum(int[] numbersArray) {
        int greatestSumSoFar = 0;

        for (int i = 0; i < numbersArray.length; i++) {
            System.out.println("Iteration Number: " + i);
            if (i == numbersArray.length - 1) {
                break;
            }

            int temp = numbersArray[i] + numbersArray[i + 1];

            if (temp > greatestSumSoFar) {
                greatestSumSoFar = temp;
            }
        }

        return greatestSumSoFar;
    }

}
