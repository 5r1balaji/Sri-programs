package com.techgeek.sri.binarytree;

import java.util.LinkedList;
import java.util.Queue;

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
        root.right.left= new BinaryTree( 4);

        root.right.right= new BinaryTree( 15);
        root.right.right.right= new BinaryTree( 20);

        root.left= new BinaryTree(6);
        root.left.left= new BinaryTree(10);
        root.left.left.right = new BinaryTree(7);
        root.left.left.right.left = new BinaryTree(11);
        System.out.println( findMinimumDepth(root));
    }

    private static int  findMinimumDepth(BinaryTree root, int height,Integer result) {
       if (root == null) {
          return 1;
       }
       if (root.left == null && root.right == null) {
           if (result == null || result > height) {
               result = height;
           }
           return result;
       }
       if (root.left != null) {
          result = findMinimumDepth(root.left,height+1,result);
       }
       if (root.right != null) {
          result = findMinimumDepth(root.right,height+1,result);
       }
       return result;
    }

    private static int findMinimumDepth(BinaryTree root) {
        Integer result = null;
        if (root == null) {
            return 1;
        }
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        int height =1;
        while(!queue.isEmpty()) {
            int count = queue.size();
            for (int i =0;i<count;i++) {
                BinaryTree tree = queue.poll();
                if (tree.left == null && tree.right == null) {
                    if (result == null || result > height) {
                        result = height;
                    }
                }
                if (tree.left != null ) {
                    queue.add(tree.left);
                }
                if (tree.right !=  null) {
                    queue.add(tree.right);
                }
            }
            height++;
        }
        return result;
    }
}
