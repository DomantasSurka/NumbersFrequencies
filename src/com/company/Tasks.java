package com.company;
import java.util.*;

/***
 * Class for calculations.
 */
public class Tasks {

    /***
     * Method which finds frequency of each number from the list
     * @param list list of integers
     * @return map of numbers and their frequencies
     */
    public static Map<Integer, Integer> getFrequencyOfNumbers(List<Integer> list){
        if(list.size() == 0){
            throw new IllegalArgumentException("List of integers is empty in getFrequencyOfNumbers(List<Integer> list)");
        }
        Map<Integer, Integer> frequencies = new HashMap<>();
        for(Integer s: list){
            Integer count = frequencies.get(s);
            if(count == null){
                count = 0;
            }
            frequencies.put(s, count + 1);
        }
        return frequencies;
    }

    /**
     * Method which finds minimum value and maximum value in the list
     * and is used when min and max values are needed
     * while maintaining asymptotic complexity O(n) after finding both values.
     * @param list list of integers
     * @return min and max values in an integer array (min - int[0], max - int[1])
     */
    public static int[] getMinMaxValues(List<Integer> list){
        if(list.size() == 0){
            throw new IllegalArgumentException("List of integers is empty in getMinMaxValues(List<Integer> list)");
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int number : list) {
            if (number < min)
                min = number;
            if (number > max)
                max = number;
        }
        return new int[] {min, max};
    }

    /***
     * Method which finds maximum value in the map
     * and is used when only maximum value is needed.
     * @param m map of numbers
     * @return maximum value from the map
     */
    public static int getMaxValueFromMap(Map<Integer, Integer> m){
        if(m.size() == 0){
            throw new IllegalArgumentException("Map is empty in getMaxFromMap(Map<Integer, Integer> m)");
        }
        int max = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> map : m.entrySet()) {
            int frequency = map.getValue();
            if (frequency > max)
                max = frequency;
        }
        return max;
    }
}
