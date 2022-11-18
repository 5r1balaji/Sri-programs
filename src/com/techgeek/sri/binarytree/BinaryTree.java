package com.techgeek.sri.binarytree;

public class BinaryTree {
    public int data;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree() {

    }

    public BinaryTree(int data) {
        this.data = data;
    }

    public void hello() {
        System.out.println(data +1 );
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}