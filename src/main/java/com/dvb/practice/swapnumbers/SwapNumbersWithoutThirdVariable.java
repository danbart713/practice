package com.dvb.practice.swapnumbers;

import java.util.List;

public class SwapNumbersWithoutThirdVariable {

    public static void main(String[] args) {
        long firstNumber = 100L;
        System.out.println("First Number: " + firstNumber);

        long secondNumber = 50L;
        System.out.println("Second Number: " + secondNumber);

        List<Long> swappedNumbersList = swapNumbers(firstNumber, secondNumber);
        System.out.println("Swapped First Number: " + swappedNumbersList.get(0));
        System.out.println("Swapped Second Number: " + swappedNumbersList.get(1));
    }

    private static List<Long> swapNumbers(long firstNumber, long secondNumber) {
        if (firstNumber == secondNumber) {
            throw new IllegalArgumentException("First number cannot be the same as the second number.");
        }

        firstNumber = firstNumber + secondNumber;
        secondNumber = firstNumber - secondNumber;
        firstNumber = firstNumber - secondNumber;

        return List.of(firstNumber, secondNumber);
    }

}
