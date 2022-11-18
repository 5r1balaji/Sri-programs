package com.techgeek.sri.binarytree;

public class SortedArrayToBinarySearchTree {
    /**
     * arr = [34,45,67,82,91]
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = {34,45,67,82,91};

        BinaryTree b = null;
        for (int i =0;i<arr.length;i++){
           b = insertValue(arr[i],b);
        }
    }

    private static BinaryTree insertValue(int data, BinaryTree b) {
        if (b == null) {
            b = new BinaryTree();
            b.data = data;
            return b;
        }
        if (data < b.data) {
            b.left = insertValue(data,b.left);
        }
        if (data > b.data) {
           b.right = insertValue(data,b.right);
        }
        return b;
    }
}
