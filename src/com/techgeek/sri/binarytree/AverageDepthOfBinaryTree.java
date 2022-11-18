package com.techgeek.sri.binarytree;


import java.util.*;

/**
 Average depth of a Binary Tree
             5
        6        9
    10        4        15
        7                   20
    11

 Output :
 0:5
 1:7.5
 2: 9.6
 3:13.5
 4: 11
 */
public class AverageDepthOfBinaryTree {
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
        List<Double> values  = findAvg(root);
        System.out.println(values);
    }

    private static List<Double> findAvg(BinaryTree root) {
        List<Double> values = new ArrayList<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            double sum = 0;
            for (int i =0;i<count;i++) {
                BinaryTree tree = queue.poll();
                sum += tree.data;
                if (tree.left != null ) {
                    queue.add(tree.left);
                }
                if (tree.right !=  null) {
                    queue.add(tree.right);
                }
            }
            values.add(sum/count);
        }
        return values;
    }


}
