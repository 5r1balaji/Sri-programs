package com.techgeek.sri.binarytree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *                   5
 *            6            9
 *        10           4         15                     <--------------
 *            7     3    12    13    20
 *         11              22
 *             17
 */
public class RightViewOfBinaryTree {
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
        //root.right.right.right= new BinaryTree( 20);

        root.left.left= new BinaryTree(10);
        root.left.left.right = new BinaryTree(7);
        root.left.left.right.left = new BinaryTree(11);
        root.left.left.right.left.right = new BinaryTree(17);
        List<Integer> right = new ArrayList<Integer>();
        HashSet<Integer> st = new HashSet<>();
        findRight(root, right, st, 1);
        right.stream().forEach(System.out::println);
    }

    private static void findRight(BinaryTree root, List<Integer> st, HashSet<Integer> ht,int height) {
        if (root != null) {
            if (!ht.contains(height)) {
                st.add(root.data);
                ht.add(height);
            }
            findRight(root.right,st,ht,height + 1);
            findRight(root.left,st,ht,height + 1);
        }
    }
}
