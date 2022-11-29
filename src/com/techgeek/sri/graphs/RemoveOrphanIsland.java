package com.techgeek.sri.graphs;


import java.util.Queue;

/**
 * 1s represent black 0's represent white.
 * Find the islands that are not connected to any order borders and remove them
 * If the black element at i,j is connected to any other black element that are connected to border element
 * Then they are border islands they should not be removed.
 * On the other hand if the black islands are not connected to any other black islands that are not part of the border
 * family remove them.
 *
 * Example output:
 *             {1, 0, 0, 0, 0, 0},
 *             {0, 0, 0, 1, 1, 1},
 *             {0, 0, 0, 0, 1, 0},
 *             {1, 1, 0, 0, 1, 0},
 *             {1, 0, 0, 0, 0, 0},
 *             {1, 0, 0, 0, 0, 1}
 *
 *
 * Solution:
 * Traverse through 1s in the edges and and mark the connected 1's as -1
 * Create an empty matrix and mark the fields that
 */
public class RemoveOrphanIsland {

    static int[][] matrix = new int[][] {
            {1, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1, 0},
            {1, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 1}
    };


    static boolean[][] visited = new boolean[matrix.length ][matrix[0].length];
    public static void main(String[] args) {

        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println("Input");
        print();
        for (int i = 0;i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if (isBorder(i, j, m, n) && matrix[i][j] == 1 && !visited[i][j]) {
                    traverse(i, j);
                }
            }
        }

        for (int i = 0;i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                   matrix[i][j] = 0;
                }
            }
        }
        System.out.println("Output");
        print();
    }

    private static void print() {
        for (int i = 0;i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                System.out.print((matrix[i][j])+ ",");
            }
            System.out.println();
        }
    }

    private static void traverse(int i, int j) {
        if (!isValid(i , j) || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        traverse(i + 1 , j);
        traverse(i  , j + 1);
        traverse(i - 1  , j);
        traverse(i  , j - 1);

    }

    private static boolean isValid(int i, int j) {
        return i < matrix.length && i > -1 && j < matrix[0].length && j > -1 && matrix[i][j] == 1;
    }

    private static boolean isBorder(int i, int j, int m, int n) {
        if (i == 0 || j == 0 || i == m - 1 || j == n -1)
            return true;
        return false;
    }
}
