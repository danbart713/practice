package com.dvb.practice.stringreverse;

import org.apache.commons.lang3.StringUtils;

public class StringReverseStringUtils {

    public static void main(String[] args) {
        String inputString = "123456789";
        System.out.println("Input String: " + inputString);

        String outputString = reverseString(inputString);
        System.out.println("Output String: " + outputString);
    }

    private static String reverseString(String inputString) {
        return StringUtils.reverse(inputString);
    }

}
