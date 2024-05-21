package nicshal.homework22.tests;

import nicshal.homework22.CheckArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTests {

    private static CheckArray checkArray;
    private static List<Integer> testInputArray1;
    private static List<Integer> testInputArray2;
    private static List<Integer> testInputArray3;
    private static List<Integer> testInputArray4;
    private static List<Integer> testInputArray5;
    private static List<Integer> testOutputArray1;
    private static List<Integer> testOutputArray2;

    @BeforeAll
    public static void prepare() {
        checkArray = new CheckArray();
        testInputArray1 = new ArrayList<>(Arrays.asList(3, 6, 1, 0, 4, 7, 6, 77));
        testInputArray2 = new ArrayList<>(Arrays.asList(3, 6, 1, 0, 4, 7, 1, 77, 134));
        testInputArray3 = new ArrayList<>(Arrays.asList(3, 6, 11, 0, 4, 7, 6, 77));
        testInputArray4 = new ArrayList<>(Arrays.asList(1, 2, 2, 2, 1, 1));
        testInputArray5 = new ArrayList<>();
        testOutputArray1 = new ArrayList<>(Arrays.asList(0, 4, 7, 6, 77));
        testOutputArray2 = new ArrayList<>(Arrays.asList(77, 134));
    }

    @Test
    public void testManyEntriesInArray() {
        Assertions.assertArrayEquals(testOutputArray2.toArray(), checkArray.filterArray(testInputArray2).toArray());
    }

    @Test
    public void testOneEntryInArray() {
        Assertions.assertArrayEquals(testOutputArray1.toArray(), checkArray.filterArray(testInputArray1).toArray());
    }

    @Test
    public void testNotSingleEntryInArray() {
        RuntimeException thrown =
                Assertions.assertThrows(RuntimeException.class,
                        () -> checkArray.filterArray(testInputArray3).toArray());
        Assertions.assertTrue(thrown.getMessage().contains("не содержит"));
    }

    @Test
    public void testEmptyArray() {
        RuntimeException thrown =
                Assertions.assertThrows(RuntimeException.class,
                        () -> checkArray.filterArray(testInputArray5).toArray());
        Assertions.assertTrue(thrown.getMessage().contains("пустой"));
    }

    @Test
    public void testArrayFilterReturnFalse() {
        Assertions.assertFalse(checkArray.checkArray(testInputArray3));
    }

    @Test
    public void testArrayFilterReturnTrue() {
        Assertions.assertTrue(checkArray.checkArray(testInputArray4));
    }

}