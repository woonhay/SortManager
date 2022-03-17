package com.sparta.wl.binary_tree;

import com.sparta.wl.exception.ChildNotFoundException;

import java.util.ArrayList;

public class Tree implements BinaryTree {
    private final Node rootNode;

    public Tree(final int element) {
        rootNode = new Node(element);
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElement() {
        return countNode(rootNode);
    }

    private int countNode(Node rootNode) {
        if (rootNode == null)
            return 0;
        else
            return 1 + countNode(rootNode.getRightChild()) + countNode(rootNode.getLeftChild());
    }

    @Override
    public void addElement(int element) {
        addNoteToTree(rootNode, element);
    }

    @Override
    public void addElements(int[] elements) {
        for (int i = 1; i < elements.length; i ++)
            addElement(elements[i]);
    }

    @Override
    public boolean findElement(int value) {
        Node node = findNode(value);
        if (node != null) {
            return true;
        }
        else
            return false;
    }

    private Node findNode(int element) {
        Node node = rootNode;
        while (node != null){
            if (element == node.getValue()) {
                return node;
            }
            if (element < node.getValue()) {
                node = node.getLeftChild();
            }
            else {
                node = node.getRightChild();
            }
        }
        return null;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        if (findElement(element)) {
            Node node = findNode(element);
            node = node.getLeftChild();
            if (node != null)
                return node.getValue();
            else
                throw new ChildNotFoundException("No Left Child: " + element);
        }
        else
            return 0;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        if (findElement(element)) {
            Node node = findNode(element);
            node = node.getRightChild();
            if (node != null)
                return node.getValue();
            else
                throw new ChildNotFoundException("No Right Child: " + element);

        }
        else
            return 0;
    }

    @Override
    public int[] getSortedTreeAsc() {
        int[] sortedArray = new int[getNumberOfElement()];
        ArrayList<Integer> list = new ArrayList<Integer>();
        toList(rootNode, list);

        for (int i = 0; i < sortedArray.length; i ++) {
            sortedArray[i] = list.get(i);
        }
        return sortedArray;
    }

    public void toList(Node node, ArrayList list){
        if(node != null){
            toList(node.getLeftChild(), list);
            list.add(node.getValue());
            toList(node.getRightChild(), list);
        }
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] sortedArray = new int[getNumberOfElement()];
        ArrayList<Integer> list = new ArrayList<Integer>();
        toList(rootNode, list);

        for (int i = 0; i < sortedArray.length; i ++) {
            sortedArray[i] = list.get(sortedArray.length - 1 - i);
        }
        return sortedArray;
    }

    private void addNoteToTree(Node node, int element) {
        if (element < node.getValue()) {
            if (node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));
            }
            else {
                addNoteToTree(node.getLeftChild(), element);
            }
        }
        else if (element >= node.getValue()) {
            if (node.isRightChildEmpty()) {
                node.setRightChild(new Node(element));
            }
            else {
                addNoteToTree(node.getRightChild(), element);
            }
        }
    }
}
