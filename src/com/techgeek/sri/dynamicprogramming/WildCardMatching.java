package com.techgeek.sri.dynamicprogramming;

/**
 *       0 1 2 3 4 5
 *   0     x ? y * z
 *   1  x
 *   2  a
 *   3  y
 *   4  l
 *   5  m
 *   6  z
 */
public class WildCardMatching {
    public static void main(String[] args) {
        String str = "ho";
        String pattern = "**ho";

        System.out.println(isMatching(str, pattern));
    }

    private static boolean isMatching(String str, String pattern) {
        if (pattern.equals(str)) {
            return true;
        }
        int writeIndex = 0;
        boolean isFirst = true;
        char[] p = pattern.toCharArray();
        // To remove duplicate *  a**b
        for (int i = 0; i < pattern.length(); i++) {
            if (p[i] == '*' ) {
                if (isFirst) {
                    p[writeIndex++] = p[i];
                    isFirst = false;
                }
            } else {
                p[writeIndex++] = p[i];
                isFirst = true;
            }
        }

        boolean[][] visited = new boolean[str.length() + 1][writeIndex + 1];
        visited[0][0] = true;

        if (writeIndex > 0 && pattern.charAt(0) == '*') {
            visited[0][1] = true;
        }


        for (int i = 1 ; i < visited.length; i++) {
            for (int j = 1; j < visited[0].length; j++) {
                if (str.charAt(i - 1) == p[j - 1] || p[j - 1] == '?') {
                    visited[i][j] =  visited[i - 1][j - 1];
                }
                if (p[j - 1] == '*') {
                    visited[i][j] =  (visited[i-1][j] || visited[i][j-1]);
                }
            }
        }
        if (!pattern.isEmpty() && pattern.charAt(0) == '*' && writeIndex == 1 ) {
            return true;
        }
        return visited[str.length()] [writeIndex];
    }
}
