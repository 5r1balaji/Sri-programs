package com.techgeek.sri.binarytree;



/**
 *                 5
 *            6        9
 *        10        4     15
 *            7               20
 *         11
 *
 *         output :
 *         3
 **/
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(5);
        root.right = new BinaryTree(9);
       //root.right.left= new BinaryTree( 4);

        root.right.right= new BinaryTree( 15);
        root.right.right.right= new BinaryTree( 20);

        root.left= new BinaryTree(6);
        root.left.left= new BinaryTree(10);
        root.left.left.right = new BinaryTree(7);
        root.left.left.right.left = new BinaryTree(11);
        System.out.println( findMinimumDepth(root));
    }

    private static int findMinimumDepth(BinaryTree root) {
        if (root == null) {
            return Integer.MAX_VALUE; // Because the first comparison when left or right most is null does not have a value.
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(findMinimumDepth(root.left), findMinimumDepth(root.right)) + 1;
    }


}
