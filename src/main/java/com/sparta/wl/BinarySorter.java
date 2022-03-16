package com.sparta.wl;

public class BinarySorter implements Sorter {
    @Override
    public String getName(){
        return "Binary Sorter";
    }

    @Override
    public int[] sortArray(int[] numbers) {
        Tree tree = new Tree(numbers[0]);
        tree.addElements(numbers);
        int[] sortedArray = tree.getSortedTreeAsc();
        return sortedArray;
    }
}
