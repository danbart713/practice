package com.dvb.practice.stringvowels;

import java.util.List;

public class StringContainsVowelsLoop {

    public static void main(String[] args) {
        String inputString = "TEST WORDS";
        System.out.println("Input String: " + inputString);

        boolean inputStringContainsVowels = checkIfStringContainsVowels(inputString);
        System.out.println("Input String Contains Vowel(s): " + inputStringContainsVowels);
    }

    private static boolean checkIfStringContainsVowels(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("Cannot pass null.");
        }

        boolean inputStringContainsVowels = false;

        List<String> vowelList = List.of("a", "e", "i", "o", "u");

        for (String vowel : vowelList) {
            if (inputString.toLowerCase().contains(vowel)) {
                inputStringContainsVowels = true;
                break;
            }
        }

        return inputStringContainsVowels;
    }

}
