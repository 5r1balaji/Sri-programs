package com.techgeek.sri.binarytree;

/**
 *                  5
 *            6        9
 *        10        4     15
 *            7               20
 *         11
 *         ...................
 *
 *                 5
 *           9          6
 *       15    4          10
 *    20               7
 *                        11
 */
public class ValidateMirrorImageBinaryTree {
    public static void main(String[] args) {
        BinaryTree root1 = new BinaryTree(5);
        root1.right = new BinaryTree(6);
        root1.right.right= new BinaryTree( 10);
        root1.right.right.left = new BinaryTree( 7);
        root1.right.right.left.right= new BinaryTree( 11);

        root1.left= new BinaryTree(9);
        root1.left.right= new BinaryTree(4);
        root1.left.left = new BinaryTree(15);
        root1.left.left.left = new BinaryTree(20);

        BinaryTree root = new BinaryTree(5);
        root.right = new BinaryTree(9);
        root.right.left= new BinaryTree( 4);
        root.right.right= new BinaryTree( 15);
        root.right.right.right= new BinaryTree( 20);

        root.left= new BinaryTree(6);
        root.left.left= new BinaryTree(10);
        root.left.left.right = new BinaryTree(7);
        root.left.left.right.left = new BinaryTree(11);

        System.out.println(validateIdentical(root,root1));


    }

    private static boolean validateIdentical(BinaryTree root, BinaryTree root1) {
        if (root == null && root1 == null) {
            return  true;
        }
        if (root != null && root1 != null && root.data == root1.data) {
            return validateIdentical(root.left, root1.right) && validateIdentical(root.right,root1.left);
        } else {
            return false;
        }

    }
}
