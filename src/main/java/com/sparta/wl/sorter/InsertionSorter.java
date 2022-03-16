package com.sparta.wl.sorter;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertionSorter implements Sorter {

    private static Logger insertionSortLogger = Logger.getLogger("insertionSortLogger");

    @Override
    public String getName(){
        return "Insertion Sorter";
    }

    @Override
    public int[] sortArray(int[] numbers) {
        insertionSortLogger.log(Level.INFO, "Method start");
        for (int j = 1; j < numbers.length; j ++) {
            int key = numbers[j];
            int i = j - 1;
            while ( (i > -1) && ( numbers [i] > key ) ) {
                numbers [i + 1] = numbers [i];
                i --;
            }
            numbers[i + 1] = key;
        }
        insertionSortLogger.log(Level.INFO, "Method end");
        insertionSortLogger.log(Level.INFO, "Array: " + Arrays.toString(numbers));
        return numbers;
    }
}
