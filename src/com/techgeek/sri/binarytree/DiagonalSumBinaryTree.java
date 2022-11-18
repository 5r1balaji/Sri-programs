package com.techgeek.sri.binarytree;

import java.util.*;

/**
  Diagonal sum of a Binary Tree
               5
           6        9
       10        4     15
           7               20
        11

 Output :
 0:49
 1:10
 2:17
 3:11
 */
public class DiagonalSumBinaryTree {
    /**
     * Implementation using DFS
     * @param root
     * @param sum
     */
    private  static void sumOfDiagonal(BinaryTree root,
                                       HashMap<Integer,Integer> sum ) {
        if (root == null) {
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        stack.add(root);
        sum.put(0,root.data);
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> rvisited = new HashSet<>();
        int height = 0;
        while(!stack.isEmpty()) {
                BinaryTree curr = stack.peek();
                if(curr.left != null && !visited.contains(curr.left.data)) {
                    stack.add(curr.left);
                    addElement(sum,curr.left.data,height++);
                    visited.add(curr.left.data);
                    continue;
                }
                if(curr.right != null && !rvisited.contains(curr.right.data)) {
                    stack.add(curr.right);
                    addElement(sum,curr.right.data,height);
                    rvisited.add(curr.right.data);
                    continue;
                }
                stack.pop();
                // reduce the height only when the current traversing element is a "VISITED" left sub node
                if (visited.contains(curr.data)) {
                    height--;
                }

        }

    }
    private static void addElement(HashMap<Integer,Integer> sum, int data,int height) {
        if (sum.containsKey(height)) {
            sum.put(height,sum.get(height)+data);
        } else {
            sum.put(height,data);
        }
    }

    private static void sumOfDiagonal(HashMap<Integer, Integer> sum, BinaryTree root,Integer height) {
        if (root != null) {
            if (sum.containsKey(height)) {
                sum.put(height,sum.get(height)+root.data);
            } else {
                sum.put(height,root.data);
            }
            sumOfDiagonal(sum,root.left,height+1);
            sumOfDiagonal(sum,root.right,height);
        }
    }




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
        HashMap<Integer,Integer> sum = new HashMap<>();
        Long now = new Date().getTime();
       // sumOfDiagonal(root,sum);
        sumOfDiagonal(sum,root,0);
        for(Map.Entry<Integer,Integer> entry:sum.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println((new Date().getTime() -now )/ 1000.0 + "secs");
       // sumOfDiagonal(sum,root,0);




    }



}
