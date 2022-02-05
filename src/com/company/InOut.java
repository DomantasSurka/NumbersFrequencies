package com.company;
import java.util.*;

/***
 * Class for inputs from and outputs to console.
 */
public class InOut {

    /***
     * Method which prints a table of the text and the instructions
     * to be followed later when adding inputs to the console.
     */
    public static void printInitialTableToConsole(){
        System.out.println("-------------------------------------");
        System.out.println("|     NUMBER FREQUENCY IN A LIST    |");
        System.out.println("-------------------------------------");
        System.out.println("| Please type in a list of integers |");
        System.out.println("-------------------------------------");
    }

    /***
     * Method which reads input data from the console
     * and creates a list of integers. If no integers were found,
     * prints a text that the list is empty.
     * @return list of integers read from console inputs.
     */
    public static List<Integer> gatherInitialDataFromConsole(){
        System.out.print("List A: ");
        List<Integer> A = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        String[] parts = input.split("[^0-9-]+");

        if(parts.length < 1 || input.length() == 0){
            System.out.println("List of integers is empty!");
        } else {
            for (String part : parts) {
                if(!Objects.equals(part, "")) {
                    A.add(Integer.parseInt(part));
                }
            }
            System.out.println();
        }
        return A;
    }

    /***
     * Method which draws a graph of numbers frequencies to console.
     * Graph is adjusted to display various numbers ranging from -∞ to +∞
     * @param frequencies numbers and their frequencies map
     * @param maxOfFrequencies maximum frequency from the list of frequencies
     * @param minNumber the lowest number from the list of numbers
     * @param maxNumber the highest number from the list of numbers
     */
    public static void printGraphOfNumbersFrequencies(Map<Integer, Integer> frequencies, int maxOfFrequencies, int minNumber, int maxNumber){
        if(minNumber > maxNumber){
            throw new IllegalArgumentException("Minimum is bigger than maximum in printGraphOfNumbersFrequencies(Map<Integer, Integer> frequencies, int maxOfFrequencies, int minNumber, int maxNumber)");
        } else if(frequencies.size() == 0){
            System.out.println("Graph is empty.");
            return;
        }
        int tempMin = minNumber; // value used only for graph adjustments.
        System.out.println("Numbers frequencies:");

        for(int i = maxOfFrequencies; i >= 0; i--){
            System.out.print("| ");
            if(i > 0) {
                // printing frequencies
                for (int j = minNumber; j <= maxNumber; j++) {
                    // finding length of integer
                    int lengthOfInteger;
                    if(tempMin > 0) {
                        lengthOfInteger = (int)(Math.log10(tempMin) + 1);
                    } else if(tempMin == 0) {
                        // log10() cannot be applied to 0
                        lengthOfInteger = 1;
                    } else {
                        lengthOfInteger = (int)(Math.log10(Math.abs(tempMin)) + 2);
                    }

                    if (frequencies.containsKey(j) && frequencies.get(j) >= i) {
                        System.out.printf("%" + lengthOfInteger + "s", "*");
                    } else {
                        System.out.printf("%" + lengthOfInteger + "s", "");
                    }
                    System.out.print(" ");
                    tempMin++;
                }
                System.out.println("|");
                tempMin = minNumber;
            }
            else{
                // printing numbers under frequencies
                for(int k = minNumber; k <= maxNumber; k++){
                    System.out.print(k + " ");
                }
                System.out.println("|");
            }
        }
        System.out.println();
    }

    /***
     * Method which prints two lines: 1 - numbers from minNumber to maxNumber value; 2 - each number's frequency.
     * Integer numbers are aligned to their own frequencies number length.
     * @param frequencies numbers and their frequencies map
     * @param minNumber the lowest value of number
     * @param maxNumber the highest value of number
     */
    public static void printNumbersAppearance(Map<Integer, Integer> frequencies, int minNumber, int maxNumber){
        if(minNumber > maxNumber){
            throw new IllegalArgumentException("Minimum is bigger than maximum in printNumbersAppearance(Map<Integer, Integer> frequencies, int minNumber, int maxNumber)");
        } else if(frequencies.size() == 0){
            System.out.println("No numbers found.");
            return;
        }
        int tempMin = minNumber; // value used only for adjustments.
        StringBuilder frequenciesAppearance = new StringBuilder(String.format("%-11s", "Frequency:"));
        StringBuilder numbersAppearance = new StringBuilder(String.format("%-11s", "Number:" ));

        for(int i = minNumber; i <= maxNumber; i++){
            // finding length of frequency
            int frequency = frequencies.getOrDefault(i, 0);
            int lengthOfFrequency = 0;
            if(frequency == 0){
                lengthOfFrequency = 1;
            } else {
                lengthOfFrequency = (int)(Math.log10(Math.abs(frequency)) + 1);
            }

            // finding length of number
            int lengthOfInteger = 0;
            if(tempMin > 0) {
                lengthOfInteger = (int)(Math.log10(tempMin) + 1);
            } else if(tempMin == 0) {
                // log10() cannot be applied to 0
                lengthOfInteger = 1;
            } else {
                lengthOfInteger = (int)(Math.log10(Math.abs(tempMin)) + 2);
            }

            // creating String line
            if(i != maxNumber) {
                frequenciesAppearance.append(String.format("%" + lengthOfInteger + "s", frequencies.getOrDefault(i, 0))).append(", ");
                if(lengthOfFrequency > lengthOfInteger){
                    numbersAppearance.append(String.format("%" + lengthOfFrequency + "s", i)).append(", ");
                } else {
                    numbersAppearance.append(i).append(", ");
                }
            } else {
                frequenciesAppearance.append(String.format("%" + lengthOfInteger + "s", frequencies.getOrDefault(i, 0)));
                if(lengthOfFrequency > lengthOfInteger){
                    numbersAppearance.append(String.format("%" + lengthOfFrequency + "s", i));
                } else {
                    numbersAppearance.append(i);
                }
            }
            tempMin++;
        }
        System.out.println(numbersAppearance);
        System.out.println(frequenciesAppearance);
    }
}
