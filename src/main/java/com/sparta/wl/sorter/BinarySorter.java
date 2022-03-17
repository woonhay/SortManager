package com.sparta.wl.sorter;

import com.sparta.wl.sorter.binary_tree.BinaryTreeImpl;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarySorter implements Sorter {

    private static Logger binarySortLogger = Logger.getLogger("binarySortLogger");

    @Override
    public String getName(){
        return "Binary Sorter";
    }

    @Override
    public int[] sortArray(int[] numbers) {
        binarySortLogger.log(Level.INFO, "Method start");
        BinaryTreeImpl tree = new BinaryTreeImpl(numbers[0]);
        tree.addElements(numbers);
        int[] sortedArray = tree.getSortedTreeAsc();
        binarySortLogger.log(Level.INFO, "Method end");
        binarySortLogger.log(Level.INFO, "Array: " + Arrays.toString(numbers));
        return sortedArray;
    }
}
