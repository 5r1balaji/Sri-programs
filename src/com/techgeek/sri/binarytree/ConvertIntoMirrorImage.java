package com.techgeek.sri.binarytree;

/**
 *                 5
 *            6        9
 *        10        4     15
 *            7               20
 *         11
 *         ....................
 *                   5
 *             9          6
 *       15       4          10
 *    20                   7
 *                            11
 */
public class ConvertIntoMirrorImage {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(5);
        root.right = new BinaryTree(9);
        root.right.left= new BinaryTree( 4);
        root.right.right= new BinaryTree( 15);
        root.right.right.right= new BinaryTree( 20);

        root.left= new BinaryTree(6);
        root.left.left= new BinaryTree(10);
        root.left.left.right = new BinaryTree(7);
        root.left.left.right.left = new BinaryTree(11);
        convertMirrorImage(root);
        System.out.println(root);
    }

    private static void convertMirrorImage(BinaryTree root) {
        if (root != null) {
            BinaryTree k = root.left;
            root.left = root.right;
            root.right = k;
            convertMirrorImage(root.left);
            convertMirrorImage(root.right);
        }
    }
}
