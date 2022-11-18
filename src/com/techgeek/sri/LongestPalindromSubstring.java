package com.techgeek.sri;


/**
 * Input: Given string :"forgeeksskeegfor",
 * Output: "geeksskeeg"
 *
 * Input: Given string :"Geeks",
 * Output: "ee"
 *
 * Time Complexity O(N^2)
 */
public class LongestPalindromSubstring {

    public static void main(String[] args) {
        String str = "cbbd";
        System.out.println(longestPalindrome(str));

    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int [n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        int maxLength = 1, start = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                maxLength = 1;
                start = i;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 0; n - (j + i) > 0 ; j++) {
                if (s.charAt(j + i) == s.charAt(j) && dp[j + 1][ j + i - 1] == 1) {
                    dp[j][j + i] = 1;
                    if (i > maxLength) {
                        maxLength = i;
                        start = j;
                    }
                }
            }
        }

        return s.substring(start , start + maxLength + 1);
    }

}
