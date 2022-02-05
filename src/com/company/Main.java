package com.company;
import java.util.*;

/***
 * Main class for program's execution.
 */
public class Main {
    public static void main(String[] args) {
        /* Prints text and instructions to the console and creates a list of integers from input data. */
        InOut.printInitialTableToConsole();
        List<Integer> A = InOut.gatherInitialDataFromConsole();

        if(A.size() != 0) {
            /* Finds minimum and maximum values from the integer list.
            * Method can be called inside other calculation methods when needed (for safety reasons),
            * but for efficiency, it is better to call it here and calculate only one time.
            * minMaxNumber[0] - minimum, minMaxNumber[1] - maximum. */
            int[] minMaxNumber = Tasks.getMinMaxValues(A);

            /* Counts each number's frequency and finds the maximum value of frequency */
            Map<Integer, Integer> frequencies = Tasks.getFrequencyOfNumbers(A);
            int maxFrequency = Tasks.getMaxValueFromMap(frequencies);

            /* Draws a graph of each number frequencies. */
            InOut.printGraphOfNumbersFrequencies(frequencies, maxFrequency, minMaxNumber[0], minMaxNumber[1]);

            /* Prints each number and its frequency aligned.
             * In order to test it - copy and paste List A from line below to the console:
             * [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, -10, 10]*/
             InOut.printNumbersAppearance(frequencies, minMaxNumber[0], minMaxNumber[1]);
        }
    }
}

