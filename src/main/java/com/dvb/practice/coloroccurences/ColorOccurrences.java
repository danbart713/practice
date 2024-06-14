package com.dvb.practice.coloroccurences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ColorOccurrences {

    public static void main(String[] args) {
        String[] colorsArray = {"blue", "green", "red", "yellow", "purple", "yellow"};
        int characterCount = 6;
        System.out.println("Colors Array: " + Arrays.toString(colorsArray));

        Map<String, Integer> colorOccurrencesMap = countColorOccurrences(colorsArray, characterCount);
        System.out.println("Color Occurrences: " + colorOccurrencesMap);
    }

    private static Map<String, Integer> countColorOccurrences(String[] colorsArray, int characterCount) {
        Map<String, Integer> colorOccurrencesMap = new HashMap<>();

        for (int i = 0; i < colorsArray.length; i++) {
            if (colorsArray[i].length() == characterCount) {
                if (colorOccurrencesMap.containsKey(colorsArray[i])) {
                    colorOccurrencesMap.put(colorsArray[i], colorOccurrencesMap.get(colorsArray[i]) + 1);
                } else {
                    colorOccurrencesMap.put(colorsArray[i], 1);
                }
            }
        }

        return colorOccurrencesMap;
    }

}
