package com.sparta.wl;

public class MergeSorter implements Sorter {
    @Override
    public String getName(){
        return "Merge Sorter";
    }

    @Override
    public int[] sortArray(int[] numbers) {
        if (numbers.length > 1) {
            int m = numbers.length / 2;
            int[] array1 = new int[numbers.length / 2];
            for (int i = 0; i < array1.length; i ++) {
                array1[i] = numbers[i];
            }
            int[] array2;
            if (numbers.length % 2 == 0)
                array2 = new int[numbers.length / 2];
            else
                array2 = new int[numbers.length / 2 + 1];
            for (int i = 0; i < array2.length; i ++) {
                array2[i] = numbers[i + array1.length];
            }
            array1 = sortArray(array1);
            array2 = sortArray(array2);

            int[] sortedNumbers = sortTwoArray(array1, array2);
            return sortedNumbers;
        }
        else {
            return numbers;
        }
    }

    private int[] sortTwoArray(int[] array1, int[] array2) {

        int[] merged = new int[array1.length + array2.length];
        int array1Pos = 0;
        int array2Pos = 0;
        int mergedPos = 0;

        while(array1Pos < array1.length && array2Pos < array2.length) {
            if (array1[array1Pos] < array2[array2Pos]) {
                merged[mergedPos] = array1[array1Pos];
                array1Pos ++;
            } else {
                merged[mergedPos] = array2[array2Pos];
                array2Pos ++;
            }
            mergedPos ++;
        }

        while (array1Pos < array1.length) {
            merged[mergedPos] = array1[array1Pos];
            mergedPos ++;
            array1Pos ++;
        }

        while (array2Pos < array2.length) {
            merged[mergedPos] = array2[array2Pos];
            mergedPos ++;
            array2Pos ++;
        }

        return merged;
    }
}
