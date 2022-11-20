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
        List<Double> results = new ArrayList<>();
        return getAverage(Collections.singletonList(root), results);
    }

    private static List<Double> getAverage(List<BinaryTree> nodes, List<Double> results) {
        if (nodes.isEmpty()) {
            return results;
        }
        List<BinaryTree> children = new ArrayList<>();
        Double avg = nodes.stream().mapToDouble(k -> mutateChildren(children, k)).average().orElse(0.00);
         // Double avg = nodes.stream().mapToDouble(k -> k.data).average().orElse(0.00);
        //List<BinaryTree> children = nodes.stream().flatMap(k -> getChildren(k).stream()).collect(Collectors.toList());
        results.add(avg);
        getAverage(children, results);
        return results;
    }

   /* private static List<BinaryTree> getChildren(BinaryTree node) {
        List<BinaryTree> children = new ArrayList<>();
        if (node.left != null) {
            children.add(node.left);
        }
        if (node.right != null) {
            children.add(node.right);
        }
        return children;
    }*/

    private static double mutateChildren(List<BinaryTree> children, BinaryTree node) {
        if (node.left != null) {
            children.add(node.left);
        }
        if (node.right != null) {
            children.add(node.right);
        }
        return node.data;
    }


}
