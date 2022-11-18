package com.techgeek.sri.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find the shortest distance from the gate which is identified as -2
 * and -1 means a wall , 0 represents the node which needs to updated with min
 * distance from the gate.
 *
 * ex : [0 , 0 , -1 , -2
 *       -2 ,0  , 0 ,  0 ]
 *
 * output :
 *   [ 1, 2 , -1, -2 ]
 *     -2 ,1 ,2,  1]
 *
 *
 *     Added the solution both by BFS and DFS
 */

class Vertice {
    int i;
    int j;

    public Vertice(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
public class ShortestDistanceFromGate {

    public static void main(String[] args) {
        int [][] input = { {0 , 0 , -1 , 0} ,
                           {0 ,-2,  0 , 0},
                           {0 , 0, 0, 0 }};
        String type = "dfs";
        if (type.equals("bfs")) {
            findShortestByBFS(input);
        } else {
            findShortest(input);
        }

        for (int i = 0;i<input.length;i++) {
            for (int j =0;j<input[0].length;j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    private static void findShortest(int [][] input) {
        boolean visited[][] = new boolean[input.length][input[0].length];
        for (int i =0;i<input.length;i++) {
            for (int j =0;j<input[0].length;j++) {
                if (input[i][j] == -2) {
                    dfs(input,visited,i+1,j,1);
                    dfs(input,visited,i,j+1,1);
                    dfs(input,visited,i-1,j,1);
                    dfs(input,visited,i,j-1,1);
                }
            }
        }
    }

    private static void dfs(int[][] input, boolean[][] visited, int i, int j,int depth) {
        if (!isValid(input,i,j,visited)) {
            return;
        }
        if (input[i][j] == 0 || input[i][j] > depth) {
            input[i][j] = depth;
            visited[i][j] = true;
            dfs(input,visited,i+1,j,depth+1);
            dfs(input,visited,i,j+1,depth+1);
            dfs(input,visited,i-1,j,depth+1);
            dfs(input,visited,i,j-1,depth+1);
            visited[i][j] = false;
        }

    }

    private static boolean isValid(int[][] input, int i, int j, boolean[][] visited) {
        return i > -1 && j > -1 && i < input.length && j < input[0].length && !visited[i][j] && input[i][j] != -1 && input[i][j] != -2;
    }
    private static void findShortestByBFS(int[][] input) {
        Queue<Vertice> nextToVisit = new LinkedList<>();

        int m = input.length;
        int n = input[0].length;
        boolean [] [] visited = new boolean[m][n];
        for (int i = 0;i<m;i++) {
            for (int j =0;j<n;j++) {
                   if( input[i][j] == -2) {
                       if (isValid(new Vertice(i,j+1),m,n,input,visited)) {
                           nextToVisit.add(new Vertice(i,j+1));
                       }
                       if (isValid(new Vertice(i+1,j),m,n,input,visited)) {
                           nextToVisit.add(new Vertice(i+1,j));
                       }
                       if (isValid(new Vertice(i,j-1),m,n,input,visited)) {
                           nextToVisit.add(new Vertice(i,j-1));
                       }
                       if (isValid(new Vertice(i-1,j),m,n,input,visited)) {
                           nextToVisit.add(new Vertice(i-1,j));
                       }
                        validateMatrix(input,nextToVisit,visited,1);
                   }
                }
            }
        }

    private static void validateMatrix(int[][] input,Queue<Vertice> nextToVisit,boolean [][] visited,int depth) {
        int m = input.length;
        int n = input[0].length;
        while(!nextToVisit.isEmpty()) {
            Vertice v = nextToVisit.poll();
            if ((input[v.i][v.j] == 0 || input[v.i][v.j] > depth)) {
                input[v.i][v.j] = depth;
                Queue<Vertice> newVisits = new LinkedList<>();
                visited[v.i][v.j] = true;
                if (isValid(new Vertice(v.i,v.j+1),m,n,input,visited)) {
                    newVisits.add(new Vertice(v.i,v.j+1));
                }
                if (isValid(new Vertice(v.i+1,v.j),m,n,input,visited)) {
                    newVisits.add(new Vertice(v.i+1,v.j));
                }
                if (isValid(new Vertice(v.i,v.j-1),m,n,input,visited)) {
                    newVisits.add(new Vertice(v.i,v.j-1));
                }
                if (isValid(new Vertice(v.i-1,v.j),m,n,input,visited)) {
                    newVisits.add(new Vertice(v.i-1,v.j));
                }
                validateMatrix(input,newVisits,visited,depth+1);
                visited[v.i][v.j] = false;
            }
        }
    }




    private static boolean isValid(Vertice v,int m,int n,int [][]input,boolean [][] visited) {
        return v.i > -1 && v.j > -1 && v.i < m && v.j < n  && input[v.i][v.j] != -1 && input[v.i][v.j] != -2  && !visited[v.i][v.j];
    }
}
