package com.sparta.wl.start;

import com.sparta.wl.exception.SorterLoaderException;
import com.sparta.wl.sorter.Sorter;

import java.util.Scanner;

public class SortLoader {

    public static void start() {

        com.sparta.wl.display.DisplayManager displayManager = new com.sparta.wl.display.DisplayManager();

        Scanner scanner = new Scanner(System.in);

        displayManager.displaySortChoices();

        int sorterNum;

        while (!scanner.hasNextInt()) {
            System.out.println("Input must between 1 and 5");
            displayManager.displaySortChoices();
            scanner.next();
        }

        sorterNum = scanner.nextInt();

        while (sorterNum < 1 || sorterNum > 6) {
            System.out.println("Input must between 1 and 6");
            displayManager.displaySortChoices();
            while (!scanner.hasNextInt()) {
                System.out.println("Input must between 1 and 6");
                displayManager.displaySortChoices();
                scanner.next();
            }
            sorterNum = scanner.nextInt();
        }

        System.out.println("Please enter the size of array you wish to generate:");

        int arraySize;

        while (!scanner.hasNextInt()) {
            System.out.println("Input must between 1 and 1000");
            System.out.println("Please enter the size of array you wish to generate:");
            scanner.next();
        }

        arraySize = scanner.nextInt();

        while (arraySize < 1 || arraySize > 1000) {
            System.out.println("Input must between 1 and 1000");
            System.out.println("Please enter the size of array you wish to generate:");
            while (!scanner.hasNextInt()) {
                System.out.println("Input must between 1 and 1000");
                System.out.println("Please enter the size of array you wish to generate:");
                scanner.next();
            }
            arraySize = scanner.nextInt();
        }

        int[] array = new int[arraySize];

        int max = 1000;

        int min = - 1000;

        for (int i = 0; i < array.length; i ++) {
            array[i] = (int) Math.floor(Math.random() * (max - min + 1) + min);
        }

        SortFactory sortFactory = new SortFactory();
        Sorter sorter = null;
        try {
            sorter = sortFactory.getSorter(sorterNum);
        } catch (SorterLoaderException e) {
            e.printStackTrace();
        }

        displayManager.printBeforeSort(sorter, array);
        displayManager.printResult(sorter, array);
    }
}
