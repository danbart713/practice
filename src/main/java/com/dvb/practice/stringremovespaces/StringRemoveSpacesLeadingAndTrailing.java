package com.dvb.practice.stringremovespaces;

import java.time.Duration;
import java.time.Instant;

public class StringRemoveSpacesLeadingAndTrailing {

    public static void main(String[] args) {
        Instant start = Instant.now();

        String inputString = " race  car 2 ";
        System.out.println("Input String: " + inputString);

        String outputString = removeStringSpaces(inputString);
        System.out.println("Output String With Spaces Removed: " + outputString);

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time Elapsed: " + timeElapsed + " milliseconds");
    }

    private static String removeStringSpaces(String inputString) {
        return inputString.strip();
    }

}
