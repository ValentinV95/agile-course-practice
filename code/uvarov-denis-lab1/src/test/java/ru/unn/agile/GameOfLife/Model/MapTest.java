package ru.unn.agile.GameOfLife.Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class MapTest {

    @Test(expected = IllegalArgumentException.class)
    public void couldNotCreateMapWithNullArgument() {
        Map testMap = new Map(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void couldNotCreateMapWithIncorrectGrid() {
        int[][] grid = {{}};
        Map testMap = new Map(grid);
    }

    @Test(expected = IllegalArgumentException.class)
    public void couldNotCreateMapWithIncorrectGridFormat() {
        int[][] grid = {{0, 0}, {0, 0, 0}};
        Map testMap = new Map(grid);
    }

    @Test(expected = IllegalArgumentException.class)
    public void couldNotCreateMapWithIncorrectGridValues() {
        int[][] grid = {{5, 0}, {0, 0}};
        Map testMap = new Map(grid);
    }

    @Test
    public void shouldCreateMapWithInputParameters() {
        int[][] grid = {{1, 0, 0}, {0, 1, 0}};
        Map testMap = new Map(grid);
        assertTrue(isEqualsGrids(grid, testMap.getGrid()));
    }

    @Test
    public void shouldCorrectlyCalculateSizeOfGrid() {
        int[][] grid = {{1, 0, 0}, {0, 1, 0}};
        int[] gridSize = {2, 3};
        Map testMap = new Map(grid);
        assertArrayEquals(testMap.getSize(), gridSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void couldNotReturnAliveNeighborsCountForIncorrectCoordinates() {
        int[][] grid = {{0}};
        Map testMap = new Map(grid);
        testMap.countAliveNeighbors(1, 1);
    }

    @Test
    public void shouldReturnZeroForDeadGrid() {
        int[][] grid = {{0}};
        Map testMap = new Map(grid);
        assertEquals(0, testMap.countAliveNeighbors(0, 0));
    }

    @Test
    public void shouldReturnCorrectValueForUpperLeftPoint() {
        int[][] grid = {{1, 1}, {1, 1}};
        Map testMap = new Map(grid);
        assertEquals(3, testMap.countAliveNeighbors(0, 0));
    }

    @Test
    public void shouldReturnCorrectValueForUpperRightPoint() {
        int[][] grid = {{1, 1}, {1, 1}};
        Map testMap = new Map(grid);
        assertEquals(3, testMap.countAliveNeighbors(1, 0));
    }

    @Test
    public void shouldReturnCorrectValueForLowerLeftPoint() {
        int[][] grid = {{1, 1}, {1, 1}};
        Map testMap = new Map(grid);
        assertEquals(3, testMap.countAliveNeighbors(0, 1));
    }

    @Test
    public void shouldReturnCorrectValueForLowerRightPoint() {
        int[][] grid = {{1, 1}, {1, 1}};
        Map testMap = new Map(grid);
        assertEquals(3, testMap.countAliveNeighbors(1, 1));
    }

    @Test
    public void shouldReturnCorrectValueForPointWith8Neighbors() {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        Map testMap = new Map(grid);
        assertEquals(testMap.countAliveNeighbors(1, 1), 8);
    }

    public static boolean isEqualsIntArrays(final int[] firstArray, final int[] secondArray) {
        boolean result = true;
        try {
            for (int i = 0; i < firstArray.length; i++) {
                result = result && (firstArray[i] == secondArray[i]);
            }
        } catch (Exception e) {
            return false;
        }
        return result;
    }

    public static boolean isEqualsGrids(final int[][] firstGrid, final int[][] secondGrid) {
        boolean result = true;
        try {
            for (int i = 0; i < firstGrid.length; i++) {
                result = result && isEqualsIntArrays(firstGrid[i], secondGrid[i]);
            }
        } catch (Exception e) {
            return false;
        }
        return result;
    }
}
