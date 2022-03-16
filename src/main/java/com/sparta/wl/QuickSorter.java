package com.sparta.wl;

public class QuickSorter implements Sorter {
    @Override
    public String getName(){
        return "Quick Sorter";
    }

    @Override
    public int[] sortArray(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
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
