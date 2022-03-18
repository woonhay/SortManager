package com.sparta.wl.sorter;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectionSorter implements Sorter {

    private static Logger selectionSortLogger = Logger.getLogger("selectionSortLogger");

    @Override
    public String getName() {
        return "Selection Sorter";
    }

    @Override
    public int[] sortArray(int[] numbers) {
        selectionSortLogger.log(Level.INFO, "Method start");
        int n = numbers.length;
        for (int i = 0; i < n - 1; i ++)
        {
            int min = i;
            for (int j = i + 1; j < n; j ++)
                if (numbers[j] < numbers[min])
                    min = j;
            int temp = numbers[min];
            numbers[min] = numbers[i];
            numbers[i] = temp;
        }
        selectionSortLogger.log(Level.INFO, "Method end");
        selectionSortLogger.log(Level.INFO, "Array: " + Arrays.toString(numbers));
        return numbers;
    }
}
