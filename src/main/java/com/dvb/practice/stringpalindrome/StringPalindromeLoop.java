package com.dvb.practice.stringpalindrome;

import java.time.Duration;
import java.time.Instant;

public class StringPalindromeLoop {

    public static void main(String[] args) {
        Instant start = Instant.now();

        String inputString = "racecar";
        System.out.println("Input String: " + inputString);

        boolean palindrome = checkIfStringIsPalindrome(inputString);
        System.out.println("Input String Is Palindrome: " + palindrome);

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time Elapsed: " + timeElapsed + " milliseconds");
    }

    private static boolean checkIfStringIsPalindrome(String inputString) {
        int inputStringLength = inputString.length();

        for (int i = 0; i < inputStringLength / 2; i++) {
            if (inputString.charAt(i) != inputString.charAt(inputStringLength - 1 - i)) {
                return false;
            }
        }

        return true;
    }

}
