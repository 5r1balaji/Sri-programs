package com.techgeek.sri.graphs;

/**
 * Solution:
 * Mark the visited index as 0 instead of creating a new visited index array
 * Use DFS
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char a[][] = {
                       {'1','1','1','1','0'},
                       {'1','1','0','1','0'},
                       {'0','1','0','0','0'},
                       {'0','0','0','1','1'}
        };

        System.out.println(findIslands(a));
    }

    private static int findIslands(char[][] a) {
        int islands = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0;j < a[0].length; j++) {
                if (a[i][j] == '1') {
                    exploreIsland(a,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void exploreIsland( char[][] a,int i , int j) {
        if (!isValid(i,j,a)) {
            return;
        }
        a[i][j] = 0;
        exploreIsland(a, i, j + 1);
        exploreIsland(a, i, j - 1);
        exploreIsland(a, i + 1, j);
        exploreIsland(a, i - 1, j);

    }

    private static boolean isValid(int i, int j, char a[][]) {
        return i < a.length && j < a[0].length && i >= 0 && j >= 0 && a[i][j] == '1';
    }
}
