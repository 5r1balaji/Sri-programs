package com.techgeek.sri.graphs;

import java.util.*;

/**
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
 *
 * Return the size of the largest island in grid after applying this operation.
 *
 * An island is a 4-directionally connected group of 1s.
 * Example 1:
 *
 * Input: grid = [[1,0],[0,1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * Example 2:
 *
 * Input: grid = [[1,1],[1,0]]
 * Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 * Example 3:
 *
 * Input: grid = [[1,1],[1,1]]
 * Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 *
 *
 * Constraints:
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 500
 * grid[i][j] is either 0 or 1.
 *
 * Solution :
 * Idea is to find the family of islands and their counts and add them into the HashMap
 * if 2 '1's are interconnected that means they are a family whose string index = "i,j"
 * are same for all the subsequent inter connections
 * i.e if  [0,0] and 0,1 are interconnected 1's then they belong to the same family [0,0]
 *
 * Once they are found , we can simply take 0's and find if the adjacent value contains 1
 * if so find the family it belongs to and take the island count
 * If 2 of the adjacents belong to the same family , add only one island count.
 * i.e count += IslandFamily count
 * Add count + 1 for including the current 0
 * whichever 0 has the highest family count then return the max.
 *
 * When there is no 0's or no 1's return the highest Island count.
 *
 * TimeComplexity:
 * O(N) + O(N)
 * where N is the size of the grid.
 *
 */
public class MakeLargestIsland {
    public static void main(String[] args) {
        char a[][] = {
                {'1','0','0','1','1'},
                {'1','0','0','1','1'},
                {'0','1','0','0','0'},
                {'0','0','0','0','1'},
                {'0','0','0','1','1'}
        };

        System.out.println(findAreaOfLargestIsland(a));
    }

    private static int findArea(char[][] a, boolean[][] visited, int i, int j, String[][] family) {
        Queue<Integer[]> queue = new LinkedList<>();
        Integer[] ch = new Integer[2];
        ch[0] = i;
        ch[1] = j;
        queue.add(ch);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Integer[] indices = queue.poll();
                int i1 = indices[0];
                int j1 = indices[1];

                if (visited[i1][j1]) {
                    continue;
                }
                family[i1][j1] = i + "," + j;
                count++;
                visited[i1][j1] = true;
                if (isValid(i1 + 1 , j1, a , visited)) {
                    queue.add(getNewIndex(i1 + 1 , j1));
                }

                if (isValid(i1 , j1 + 1, a , visited)) {
                    queue.add(getNewIndex(i1, j1 +1));
                }

                if (isValid(i1 - 1 , j1, a , visited)) {
                    queue.add(getNewIndex(i1 - 1 , j1));
                }

                if (isValid(i1 , j1 - 1, a , visited)) {
                    queue.add(getNewIndex(i1 , j1 - 1));
                }

            }
        }
        return count;
    }

    private static int findAreaOfLargestIsland(char[][] a) {
        boolean[][] visited = new boolean[a.length][a.length];
        HashMap<String,Integer> islandCount = new HashMap<>();
        String[][] family = new String[a.length][a.length];
        int hMax = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == '1' && !visited[i][j]) {
                   int count = findArea(a, visited, i , j , family);
                   hMax = Math.max(count, hMax);
                   family[i][j] = i + "," + j;
                   islandCount.put(i + "," + j, count);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == '0') {
                    HashSet<String> set = new HashSet<>();
                    int count = 0;
                    if (isValidIndex(i, j - 1, a) && !set.contains(family[i][j-1])) {
                        set.add(family[i][j-1]);
                        count += islandCount.getOrDefault(family[i][j - 1], 0);
                    }
                    if (isValidIndex(i, j + 1, a) && !set.contains(family[i][j + 1])) {
                        set.add(family[i][j + 1]);
                        count += islandCount.getOrDefault(family[i][j + 1], 0);
                    }
                    if (isValidIndex(i + 1, j, a ) && !set.contains(family[i + 1][j])) {
                        set.add(family[i + 1][j]);
                        count += islandCount.getOrDefault(family[i + 1][j], 0);
                    }
                    if (isValidIndex(i - 1, j, a) && !set.contains(family[i - 1][j])) {
                        set.add(family[i - 1][j]);
                        count += islandCount.getOrDefault(family[i - 1][j], 0);
                    }
                    max = Math.max(count + 1, max) ;
                }

            }
        }
        if (max == 0) {
            return Math.max(hMax, 1);
        }
        return max;
    }


    private static Integer[] getNewIndex(int i, int j) {
        Integer[] k = new Integer[2];
        k[0] = i;
        k[1] = j;
        return k;
    }

    private static boolean isValidIndex(int i, int j, char[][] a) {
        return i > -1 && i < a.length && j > -1 && j < a.length && a[i][j] == '1';
    }

    private static boolean isValid(int i, int j, char[][] a, boolean[][] visited) {
        return isValidIndex(i, j, a) && !visited[i][j];
    }
}
