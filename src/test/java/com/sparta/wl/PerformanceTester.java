package com.sparta.wl;

import com.sparta.wl.start.SortFactory;
import com.sparta.wl.exception.SorterLoaderException;
import com.sparta.wl.sorter.Sorter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class PerformanceTester {
    private int[] unsortedArray;
    private static int[] arrayToSort;

    @BeforeAll
    public static void classSetup() {
        Random random = new Random();
        arrayToSort = new int[100];
        for (int i = 0; i < 100; i ++) {
            arrayToSort[i] = random.nextInt(1000) + 1;
        }
    }

    @BeforeEach
    public void setup() {
        unsortedArray = arrayToSort.clone();
    }

    @Test
    public void testBinarySorter() throws SorterLoaderException {
        print(1);
    }

    @Test
    public void testBubbleSorter() throws SorterLoaderException {
        print(2);
    }

    @Test
    public void testInsertionSorter() throws SorterLoaderException {
        print(3);
    }

    @Test
    public void testMergeSorter() throws SorterLoaderException {
        print(4);
    }

    @Test
    public void testQuickSorter() throws SorterLoaderException {
        print(5);
    }

    @Test
    public void testSelectionSorter() throws SorterLoaderException {
        print(6);
    }

    private void print(int i) throws SorterLoaderException {
        System.out.println("*************" + Arrays.toString(unsortedArray));
        Sorter sorter = SortFactory.getSorter(i);
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter.getName(), end - start, sortedArray);
    }

    private void printResults(String name, long l, int[] sortedArray) {
        System.out.println(name + ":");
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("Time taken: " + l + " nano seconds");
    }

}
