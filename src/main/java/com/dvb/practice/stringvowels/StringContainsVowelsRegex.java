package com.dvb.practice.stringvowels;

public class StringContainsVowelsRegex {

    public static void main(String[] args) {
        String inputString = "TEST WORDS";
        System.out.println("Input String: " + inputString);

        StringContainsVowelsRegex stringContainsVowelsRegex = new StringContainsVowelsRegex();
        stringContainsVowelsRegex.test();

        boolean inputStringContainsVowels = checkIfStringContainsVowels(inputString);
        System.out.println("Input String Contains Vowel(s): " + inputStringContainsVowels);
    }

    private static boolean checkIfStringContainsVowels(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("Cannot pass null.");
        }

        return inputString.toLowerCase().matches(".*[aeiou].*");
    }

    private void test() {

    }

}
