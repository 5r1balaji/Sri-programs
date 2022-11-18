package com.techgeek.sri.graphs;

public class PossibleWaysFromAPoint {
    public static void main(String[] args) {
        int num[][] =  {{0,0,1,0},
                        {0,0,0,0},
                        {1,0,1,1},
                        {1,0,0,0}};
        int  count [][] = new int[num.length][num[0].length];
        int x=0,y=3;
        System.out.println(possibleWays(num,count,0,0,x,y));

        for (int i = 0;i < num.length; i++) {
            for (int j = 0; j < num[0].length; j++) {
                System.out.print(count[i][j] + "\t");
            }
            System.out.println("\n");
        }

    }

    private static int possibleWays(int[][] num,int [][]visited,int i, int j,int endi,int endj) {
        if (!isValid(num,i,j)) {
            return 0;
        }
        if (i == endi && j == endj) {
            return 1;
        }


        return visited[i][j] = possibleWays(num,visited,i+1,j,endi,endj) + possibleWays(num,visited,i,j+1,endi,endj);

    }

    private static boolean isValid(int[][] num, int i, int j) {
        return i < num.length && j < num[0].length && num[i][j] != 1;
    }
}
