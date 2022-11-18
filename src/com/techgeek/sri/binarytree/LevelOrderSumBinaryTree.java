package com.techgeek.sri.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 *                   5
 *            6            9
 *        10           4         15
 *            7     3    12    13    20
 *         11              22
 */
public class LevelOrderSumBinaryTree {

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(5);
        root.right = new BinaryTree(9);
        root.right.left= new BinaryTree( 4);
        root.right.left.left= new BinaryTree( 3);
        root.right.left.right= new BinaryTree( 12);
        root.right.left.right.right= new BinaryTree( 22);
        root.right.right= new BinaryTree( 15);
        root.right.right.left= new BinaryTree( 13);
        root.right.right.right= new BinaryTree( 20);

        root.left= new BinaryTree(6);
        root.left.left= new BinaryTree(10);
        root.left.left.right = new BinaryTree(7);
        root.left.left.right.left = new BinaryTree(11);
        HashMap<Integer,Integer> sum = new HashMap<>();
        levelOrderSum(sum,root,0);

        for(Map.Entry<Integer,Integer> entry:sum.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    private static void levelOrderSum(HashMap<Integer, Integer> sum, BinaryTree root, int level) {
        if (root != null) {
            if (sum.containsKey(level)) {
                sum.put(level,sum.get(level)+root.data);
            } else {
                sum.put(level,root.data);
            }
            levelOrderSum(sum,root.left,level+1);
            levelOrderSum(sum,root.right,level+1);
        }
    }
}
