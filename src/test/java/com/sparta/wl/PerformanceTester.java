package com.sparta.wl;

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
    public void testBubbleSorter() {
        System.out.println("*************" + Arrays.toString(unsortedArray));
        Sorter sorter = new BubbleSort();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter.getName(), end - start, sortedArray);
    }

    @Test
    public void testInsertionSorter() {
        System.out.println("*************" + Arrays.toString(unsortedArray));
        Sorter sorter = new InsertionSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter.getName(), end - start, sortedArray);
    }

    @Test
    public void testQuickSorter() {
        System.out.println("*************" + Arrays.toString(unsortedArray));
        Sorter sorter = new QuickSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter.getName(), end - start, sortedArray);
    }

    @Test
    public void testMergeSorter() {
        System.out.println("*************" + Arrays.toString(unsortedArray));
        Sorter sorter = new MergeSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter.getName(), end - start, sortedArray);
    }

    @Test
    public void testBinarySorter() {
        System.out.println("*************" + Arrays.toString(unsortedArray));
        Sorter sorter = new BinarySorter();
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
