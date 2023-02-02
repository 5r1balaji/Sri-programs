package com.techgeek.sri.graphs;

import java.util.Stack;

/**
 * The 1 represents water 0 represents land.. Find the maximum number of elements trapped
 * together.
 * The {0,1,0,0},
 *     {0,0,1,1},
 *     {1,1,1,1},
 *     {0,0,1,1}};
 *     output of this is 8
 */
 public class FindMaxTrappedWater {
        static boolean  [][] visited = new boolean[4][4];
        static    int m =4,n=4;
        public static void main(String args[]) {
                int matrix[][] =     {
                                        {0,1,0,0},
                                        {0,0,1,1},
                                        {1,1,1,1},
                                        {0,0,1,1}};

            int maxSum = 0;
            for (int i = 0;i < m; i++ ) {
                for (int j = 0;j < n;j++) {
                    if (!visited[i][j] && matrix[i][j] == 1 ) {
                        int sum = depthFirstSearch(matrix, i, j);
                        maxSum = Math.max(sum, maxSum);
                    }
                    visited[i][j] = true;
                }
            }
            System.out.println(maxSum);
        }
        static int depthFirstSearch( int matrix[][], int i, int j) {
            if ( !isValid(i, j, matrix)) {
                return 0;
            }
            visited[i][j] = true;
            int sum = depthFirstSearch(matrix,i + 1, j);
            sum += depthFirstSearch(matrix,i - 1, j);
            sum += depthFirstSearch(matrix, i, j + 1);
            sum += depthFirstSearch(matrix, i , j - 1);
            return sum + 1;
        }

    private static boolean isValid(int i, int j, int[][] matrix) {
            return i >= 0  && i < m && j >= 0 && j < n && !visited[i][j] && matrix[i][j] == 1;
    }
}
