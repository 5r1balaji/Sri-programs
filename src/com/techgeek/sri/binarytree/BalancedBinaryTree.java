package com.techgeek.sri.binarytree;
/**
 *              6
 *          4     10
 *               5   11
 *              7
 *       if difference between height of left subtree and right subtree is less than or equal to 1
 *       then it is a balanced subtree.
 **/
public class BalancedBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(6);
        tree.right = new BinaryTree(10);
        tree.right.left = new BinaryTree(5);
        tree.right.left.left = new BinaryTree(7);
        //tree.right.left.left.right = new BinaryTree(8);
        tree.right.right = new BinaryTree(11);

        tree.left = new BinaryTree(4);

        System.out.println(isBalancedTree(tree) != Integer.MAX_VALUE);


    }

    private static int isBalancedTree(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }
        int left = isBalancedTree(tree.left);
        int right = isBalancedTree(tree.right);

        if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE || Math.abs(isBalancedTree(tree.left) - isBalancedTree(tree.right) ) > 1) {
            return Integer.MAX_VALUE; // Max value is used as a flag to identify if there is any imbalance in the subtree.
        }
        return  Math.max(left, right) + 1;// This will return the height of the tree at the node i.e + 1
    }
}
