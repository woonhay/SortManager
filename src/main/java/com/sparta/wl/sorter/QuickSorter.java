package com.sparta.wl.sorter;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuickSorter implements Sorter {

    private static Logger quickSortLogger = Logger.getLogger("quickSortLogger");

    @Override
    public String getName(){
        return "Quick Sorter";
    }

    @Override
    public int[] sortArray(int[] numbers) {
        quickSortLogger.log(Level.INFO, "Method start");
        quickSort(numbers, 0, numbers.length - 1);
        quickSortLogger.log(Level.INFO, "Method end");
        quickSortLogger.log(Level.INFO, "Array: " + Arrays.toString(numbers));
        return numbers;
    }

    private void quickSort(int[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private void swap(int[] arr, int low, int pivot){
        int tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    private int partition(int[] arr, int low, int high){
        int p = low, j;
        for(j = low + 1; j <= high; j ++)
            if(arr[j] < arr[low])
                swap(arr, ++p, j);

        swap(arr, low, p);
        return p;
    }
}
