package com.dvb.practice.stringreverse;

public class StringReverseNoCharArray {

    public static void main(String[] args) {
        String inputString = "123456789";
        System.out.println("Input String: " + inputString);

        String outputString = reverseString(inputString);
        System.out.println("Output String: " + outputString);
    }

    private static String reverseString(String inputString) {
        char tempChar;
        String outputString = "";

        for (int i = 0; i < inputString.length(); i++) {
            tempChar = inputString.charAt(i);
            outputString = tempChar + outputString;
        }

        return outputString;
    }

}
