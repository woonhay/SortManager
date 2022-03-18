package com.sparta.wl.start;

import com.sparta.wl.exception.SorterLoaderException;
import com.sparta.wl.sorter.*;
import com.sparta.wl.sorter.SelectionSorter;

public class SortFactory {

    public static Sorter getSorter(int choice) throws SorterLoaderException {
        switch (choice) {
            case 1:
                return new BinarySorter();
            case 2:
                return new BubbleSorter();
            case 3:
                return new InsertionSorter();
            case 4:
                return new MergeSorter();
            case 5:
                return new QuickSorter();
            case 6:
                return new SelectionSorter();
            default:
                throw new SorterLoaderException("Invalid Sorter choice: " + choice);
        }
    }
}
