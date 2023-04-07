package com.techgeek.sri.dynamicprogramming;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int matrix[][] =     {
                {1, 5, 15,16},
                {3, 4, 2, 17},
                {6, 7, 8, 10},
                {14,13,12,11}};
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(findMinimumPathSum(matrix, matrix.length - 1, matrix[0].length - 1, memo));
    }
    // row  = 3 , col = 3
    private static int findMinimumPathSum(int[][] matrix, int row, int col, int[][] memo) {
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        if (row == 0 && col ==0) {
            return matrix[row][col];
        }
        int res = matrix[row][col] + Math.min(
                findMinimumPathSum(matrix, row - 1, col, memo),
                findMinimumPathSum(matrix, row , col -1, memo)
        );
        memo[row][col] = res;

        return memo[row][col];

    }
}
