package com.sparta.wl;

public class SortFactory {

    public static Sorter getSorter(int choice) throws SorterLoaderException {
        switch (choice) {
            case 1:
                return new BinarySorter();
            case 2:
                return new BubbleSort();
            case 3:
                return new InsertionSorter();
            case 4:
                return new MergeSorter();
            case 5:
                return new QuickSorter();
            default:
                throw new SorterLoaderException("Invalid Sorter choice: " + choice);
        }
    }
}
