package com.company;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/***
 * Tests class made for testing InOut class methods.
 */
class InOutTest {

    /***
     * Testing method printGraphOfNumbersFrequencies(),
     * when given minimum value is bigger than maximum - this should throw exception.
     */
    @Test
    void printGraphOfNumbersFrequencies_minBiggerThanMax_shouldThrow() {
        // Arrange
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        int minNumber = 2;
        int maxNumber = 1;
        int maxOfFrequency = 1;
        // Act
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> InOut.printGraphOfNumbersFrequencies(map, maxOfFrequency, minNumber, maxNumber));
        // Assert
        assertEquals("Minimum is bigger than maximum in printGraphOfNumbersFrequencies(Map<Integer, Integer> frequencies, int maxOfFrequencies, int minNumber, int maxNumber)", thrown.getMessage());
    }

    /***
     * Testing method printNumbersAppearance(),
     * when given list in empty - text will be printed to the console.
     */
    @Test
    void printNumbersAppearance_listIsEmpty_printsToConsole() {
        // Arrange
        Map<Integer, Integer> map = new HashMap<>();
        int minNumber = 0;
        int maxNumber = 0;
        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // Act
        PrintStream tempPs = new PrintStream(baos);
        System.setOut(tempPs);
        InOut.printNumbersAppearance(map, minNumber, maxNumber);
        System.setOut(original);
        tempPs.flush();
        // Assert
        assertEquals("No numbers found.\r\n", baos.toString());
    }

    /***
     * Testing method printNumbersAppearance(),
     * when minimum value is bigger than maximum - this should throw exception.
     */
    @Test
    void printNumbersAppearance_minBiggerThanMax_shouldThrow() {
        // Arrange
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        int minNumber = 1;
        int maxNumber = 2;
        // Act (if programmer types wrong values when calling this method)
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> InOut.printNumbersAppearance(map, maxNumber, minNumber));
        // Assert
        assertEquals("Minimum is bigger than maximum in printNumbersAppearance(Map<Integer, Integer> frequencies, int minNumber, int maxNumber)", thrown.getMessage());
    }
}