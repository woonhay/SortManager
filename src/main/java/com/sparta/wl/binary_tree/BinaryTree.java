package com.sparta.wl.binary_tree;

import com.sparta.wl.exception.ChildNotFoundException;

public interface BinaryTree {
    int getRootElement();

    int getNumberOfElement();

    void addElement(int element);

    void addElements(final int[] elements);

    boolean findElement(int value);

    int getLeftChild(int element) throws ChildNotFoundException;

    int getRightChild(int element) throws ChildNotFoundException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();
}
