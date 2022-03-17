package com.sparta.wl.sorter.binary_tree;

import com.sparta.wl.exception.ChildNotFoundException;

import java.util.ArrayList;

public class BinaryTreeImpl implements BinaryTree {
    private final Node rootNode;

    public BinaryTreeImpl(final int element) {
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
        int[] ascArray = new int[getNumberOfElement()];
        ArrayList<Integer> list = new ArrayList<Integer>();
        sortTreeAsc(rootNode, list);

        for (int i = 0; i < ascArray.length; i ++) {
            ascArray[i] = list.get(i);
        }
        return ascArray;
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] descArray = new int[getNumberOfElement()];
        ArrayList<Integer> list = new ArrayList<Integer>();
        sortTreeDesc(rootNode, list);

        for (int i = 0; i < descArray.length; i ++) {
            descArray[i] = list.get(descArray.length - 1 - i);
        }
        return descArray;
    }

    public void sortTreeAsc(Node node, ArrayList list) {
        if (node != null) {
            sortTreeAsc(node.getLeftChild(), list);
            list.add(node.getValue());
            sortTreeAsc(node.getRightChild(), list);
        }
    }

    public void sortTreeDesc(Node node, ArrayList list) {
        if (node != null) {
            sortTreeDesc(node.getRightChild(), list);
            list.add(node.getValue());
            sortTreeDesc(node.getLeftChild(), list);
        }
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
