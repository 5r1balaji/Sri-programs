package com.techgeek.sri.binarytree;

/**
 *                   5
 *            6            9
 *        10           4         15
 *            7     3    12    13    20
 *         11              22
 *             17
 */
public class MaxHeightBinaryTree {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(5);
        root.left= new BinaryTree(6);
        root.right = new BinaryTree(9);
        root.right.left= new BinaryTree( 4);
        root.right.right= new BinaryTree( 15);
        root.right.left.left= new BinaryTree( 3);
        root.right.left.right= new BinaryTree( 12);
        root.right.left.right.right= new BinaryTree( 22);

        root.right.right.left= new BinaryTree( 13);
        root.right.right.right= new BinaryTree( 20);

        root.left.left= new BinaryTree(10);
        root.left.left.right = new BinaryTree(7);
        root.left.left.right.left = new BinaryTree(11);
        root.left.left.right.left.right = new BinaryTree(17);

        System.out.println(findHeight(root,0,0));
        System.out.println(findHeight(root,0));
    }


    static int findHeight(BinaryTree root, int height) {
        if (root == null) {
            return height;
        }
        return Math.max(findHeight(root.left, height + 1), findHeight(root.right, height + 1));
    }
    /**
     * The logic behind is that, at every node traversal left and right, the maximum of those 2 diversions are
     *  set for both lHeight and rHeight.
     * @param root
     * @param lHeight
     * @param rHeight
     * @return
     */
    private static int findHeight(BinaryTree root,int lHeight,int rHeight) {
        if (root == null) {
            return 0;
        } else {
            lHeight = findHeight(root.left,lHeight+1,rHeight);
            rHeight = findHeight(root.right,lHeight,rHeight+1);
          return Math.max(lHeight,rHeight)+1;
        }
    }
}
