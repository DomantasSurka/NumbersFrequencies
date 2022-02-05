package com.company;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/***
 * Tests class made for testing Tasks class methods.
 */
class TasksTest {

    /***
     * Testing method getFrequencyOfNumbers(),
     * when the given list is not empty and has more than 5 values - method returns each element frequency.
     */
    @Test
    void getFrequencyOfNumbers_listNotEmpty_getsFrequencyOfEachElement() {
        // Arrange
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 2, 2, 1, 4));
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        expected.put(2, 3);
        expected.put(3, 1);
        expected.put(4, 2);
        // Act
        Map<Integer, Integer> result = Tasks.getFrequencyOfNumbers(list);
        // Assert
        assertEquals(expected, result);
    }

    /***
     * Testing method getFrequencyOfNumbers(),
     * when the given list is empty - this should throw exception.
     */
    @Test
    void getFrequencyOfNumbers_listIsEmpty_shouldThrow() {
        // Arrange
        List<Integer> list = new ArrayList<>();
        // Act
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Tasks.getFrequencyOfNumbers(list));
        // Assert
        assertEquals("List of integers is empty in getFrequencyOfNumbers(List<Integer> list)", thrown.getMessage());
    }

    /***
     * Testing method getFrequencyOfNumbers(),
     * when list has only one element - method returns frequency of one element.
     */
    @Test
    void getFrequencyOfNumbers_listHasOneElement_getsFrequencyOfOneElement() {
        // Arrange
        List<Integer> list = new ArrayList<>(Collections.singletonList(1));
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 1);
        // Act
        Map<Integer, Integer> result = Tasks.getFrequencyOfNumbers(list);
        // Assert
        assertEquals(expected, result);
    }

    /***
     * Testing method getMinMaxValues(),
     * when the given list is empty - this should throw exception.
     */
    @Test
    void getMinMaxValues_listIsEmpty_shouldThrow() {
        // Arrange
        List<Integer> list = new ArrayList<>();
        // Act
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Tasks.getMinMaxValues(list));
        // Assert
        assertEquals("List of integers is empty in getMinMaxValues(List<Integer> list)", thrown.getMessage());
    }

    /***
     * Testing method getMinMaxValues(),
     * when the list of integers has only one value - minimum and maximum value should be the same.
     */
    @Test
    void getMinMaxValues_listHasOneValue_minAndMaxAreEqual() {
        // Arrange
        List<Integer> list = new ArrayList<>(Collections.singletonList(5));
        // Act
        int[] minMaxValues = Tasks.getMinMaxValues(list);
        // Assert
        assertEquals(minMaxValues[0], minMaxValues[1]);
    }

    /***
     * Testing method getMinMaxValues(),
     * when the list of integers has more than 10 mixed values - returns min and max values.
     */
    @Test
    void getMinMaxValues_listNotEmpty_findsMinMaxValues() {
        // Arrange
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, -10, 1, 100, -10, 5, 9, 1, 3));
        int expectedMin = -10;
        int expectedMax = 100;
        // Act
        int[] minMaxValues = Tasks.getMinMaxValues(list);
        // Assert
        assertEquals(expectedMin, minMaxValues[0]);
        assertEquals(expectedMax, minMaxValues[1]);
    }

    /***
     * Testing method getMaxValueFromMap(),
     * when the given list is empty - this should throw exception.
     */
    @Test
    void getMaxValueFromMap_listIsEmpty_shouldThrow() {
        // Arrange
        Map<Integer, Integer> map = new HashMap<>();
        // Act
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Tasks.getMaxValueFromMap(map));
        // Assert
        assertEquals("Map is empty in getMaxFromMap(Map<Integer, Integer> m)", thrown.getMessage());
    }

    /***
     * Testing method getMaxValueFromMap(),
     * when the list of integers has only one value - that value should be the maximum.
     */
    @Test
    void getMaxValueFromMap_listHasOneValue_valueIsMax() {
        // Arrange
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 1);
        int expectedMaxValue = 1;
        // Act
        int maxValue = Tasks.getMaxValueFromMap(map);
        // Assert
        assertEquals(expectedMaxValue, maxValue);
    }

    /***
     * Testing method getMaxValueFromMap(),
     * when the list of integers has more than 5 mixed values
     */
    @Test
    void getMaxValueFromMap_listNotEmpty_findsMaxValue() {
        // Arrange
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 2);
        map.put(8, 1);
        map.put(-80, 3);
        map.put(79, 2);
        map.put(90, 1);
        int expectedMaxValue = 3;
        // Act
        int maxValue = Tasks.getMaxValueFromMap(map);
        // Assert
        assertEquals(expectedMaxValue, maxValue);
    }
}