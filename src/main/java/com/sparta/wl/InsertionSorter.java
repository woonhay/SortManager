package com.sparta.wl;

public class InsertionSorter implements Sorter {
    @Override
    public String getName(){
        return "Insertion Sorter";
    }

    @Override
    public int[] sortArray(int[] numbers) {
        for (int j = 1; j < numbers.length; j ++) {
            int key = numbers[j];
            int i = j - 1;
            while ( (i > -1) && ( numbers [i] > key ) ) {
                numbers [i + 1] = numbers [i];
                i --;
            }
            numbers[i + 1] = key;
        }
        return numbers;
    }
}
