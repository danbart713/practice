package com.dvb.practice.stringreverse;

public class StringReverseCharArray {

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

        char[] inputStringCharArray = inputString.toCharArray();
        char[] outputStringCharArray = new char[inputStringCharArray.length];
        int outputIteration = 0;

        for (int i = inputStringCharArray.length - 1; i >= 0; i--) {
            outputStringCharArray[outputIteration] = inputStringCharArray[i];
            outputIteration++;
        }

        return new String(outputStringCharArray);
    }

}
