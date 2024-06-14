package com.dvb.practice.stringreverse;

public class StringReverseStringBuilder {

    public static void main(String[] args) {
        String inputString = "123456789";
        System.out.println("Input String: " + inputString);

        String outputString = reverseString(inputString);
        System.out.println("Output String: " + outputString);
    }

    private static String reverseString(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("Cannot pass null.");
        }

        StringBuilder outputStringBuilder = new StringBuilder();

        for (int i = inputString.length() - 1; i >= 0; i--) {
            outputStringBuilder.append(inputString.charAt(i));
        }

        return outputStringBuilder.toString();
    }

}
