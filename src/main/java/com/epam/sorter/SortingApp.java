package com.epam.sorter;

import java.util.Arrays;

/**
 * SortingApp is a simple application that sorts up to 10 integer command-line arguments in ascending order.
 */
public class SortingApp {

    public static void main(String[] args) {
        if (args.length == 0 || args.length > 10) {
            System.out.println("Please provide between 1 and 10 integer arguments.");
            return;
        }

        try {
            int[] numbers = Arrays.stream(args)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.sort(numbers);
            System.out.println("Sorted numbers: " + Arrays.toString(numbers));
        } catch (NumberFormatException e) {
            System.out.println("All arguments must be integers.");
        }
    }
}
