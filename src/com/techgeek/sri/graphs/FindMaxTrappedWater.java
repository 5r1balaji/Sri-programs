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
                                        {0,1,1,0},
                                        {0,0,0,1},
                                        {1,1,1,1},
                                        {0,0,1,0}};

            int maxSum = 0;
            Stack<String> pairs = new Stack<>();
            for (int i =0;i<m;i++ ) {
                for (int j =0;j<n;j++) {
                    if (visited[i][j] != true && matrix[i][j] == 1 ) {
                        pairs.add(i+","+j);
                        int sum  = 0;
                        sum = depthFirstSearch(matrix,sum,pairs);
                        maxSum = Math.max(sum,maxSum);
                    }
                    visited[i][j] = true;
                }
            }
            System.out.println(maxSum);
        }
        static int depthFirstSearch( int matrix[][], int sum,Stack<String> pairs) {
            while (!pairs.isEmpty()) {
                String k[] = pairs.pop().split(",");
                int i = Integer.parseInt(k[0]);
                int j = Integer.parseInt(k[1]);
                visited[i][j] =true;
                if (isValid(i+1,j,matrix)) {
                    visited[i+1][j] = true;
                    pairs.add((i+1) +","+j);
                }
                if (isValid(i,j+1,matrix)) {
                    visited[i][j+1] = true;
                    pairs.add(i +","+(j+1));
                }
                if (isValid(i-1,j,matrix)) {
                    visited[i-1][j] =true;
                    pairs.add((i-1) +","+j);
                }
                if (isValid(i,j-1,matrix)) {
                    visited[i][j-1] = true;
                    pairs.add(i +","+(j-1));
                }
                sum += 1;
            }
            return sum;
        }

    private static boolean isValid(int i, int j, int[][] matrix) {
            return i >= 0  && i < m && j >= 0 && j < n && visited[i][j] != true && matrix[i][j] == 1;
    }
}
