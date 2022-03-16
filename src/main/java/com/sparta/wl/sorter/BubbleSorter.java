package com.sparta.wl.sorter;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSorter implements Sorter {

    private static Logger bubbleSortLogger = Logger.getLogger("bubbleSortLogger");

    @Override
    public String getName(){
        return "Bubble Sorter";
    }

    @Override
    public int[] sortArray(int[] numbers) {
        bubbleSortLogger.log(Level.INFO, "Method start");
        int n = numbers.length;
        int temp = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 1; j < (n - i); j ++) {
                if (numbers[j - 1] > numbers[j]) {
                    temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        bubbleSortLogger.log(Level.INFO, "Method end");
        bubbleSortLogger.log(Level.INFO, "Array: " + Arrays.toString(numbers));
        return numbers;
    }

}
