package com.techgeek.sri;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"Tushar","Roy","likes","to","code"};
        int limit = 10;
        List<String> result = justifyWords(words,limit);
        result.forEach(System.out::println);
    }

    private static List<String> justifyWords(String[] words, int limit) {

        List<String> result = new ArrayList<>();
        int[][] dp = new int[words.length][words.length];
        for (int i = 0; i < words.length; i++) {
            dp[i][i] = limit - words[i].length();
            for (int j = i + 1; j < words.length;i++) {
                dp[i][j] = dp[i][j - 1] - words[j].length() - 1;
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (dp[i][j] >= 0) {
                    dp[i][j] = (int) Math.pow(dp[i][j], 2);
                }
            }
        }

        int[] subs = new int[words.length];

        for (int i = words.length - 1; i >= 0; i--) {
            int best = i;
            for (int j = i + 1; j < words.length; j++) {

            }
            subs[i] = best + 1;
        }


        return result;
    }
}
