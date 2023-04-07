package com.techgeek.sri.graphs;

import java.util.Arrays;
import java.util.List;

/**
 * Find if the users are part of the same group.
 *  It is considered as group when a user donates or receives subscription as gift from another user.
 *  The users are related to each other either directly or indirectly.
 *   i.e 0 donates to 1 and 1 donates to 2
 *   then 0 1 2 are in same group
 *
 *   00 11 22 33 represent users
 *
 *   if 0 donates to 1 it will 0,1 = 1
 *   jth value represents the user who received donation i represent from user
 *                             {1,0,0,0},
 *                             {0,1,0,0},
 *                             {0,0,1,0},
 *                             {0,0,0,1}
 *
 *     output :
 *     4
 *                              {1,0,0,0},
 *                              {1,1,0,0},
 *                              {0,0,1,0},
 *                              {0,0,1,1}
 *
 *     output:
 *      2 because 2 groups formed between user 0 and 1 or user 2 and 3
 *
 *
*
 */
public class FindGroupsAudible {
    public static void main(String[] args) {

        List<String> relations = Arrays.asList(
                "1100",
                "0100",
                "1010",
                "0001");
        int[][] matrix = new int[relations.size()][relations.size()];

        for (int i = 0; i < relations.size(); i++) {
            for (int j = 0; j < relations.size();j++) {
                matrix[i][j] = relations.get(i).charAt(j) - '0';
            }
        }
        System.out.println(findRelations(matrix));

    }
    public static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0 || M[j][i] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public static int findRelations(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }


}
