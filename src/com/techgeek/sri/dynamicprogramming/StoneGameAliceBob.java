package com.techgeek.sri.dynamicprogramming;

import java.util.Arrays;

/**
 * Alice and Bob take turns playing a game, with Alice starting first.
 *
 * There are n stones arranged in a row. On each player's turn, they can remove either the leftmost stone
 * or the rightmost stone from the row and receive points equal to the sum of the remaining stones' values in the row.
 * The winner is the one with the higher score when there are no stones left to remove.
 *
 * Bob found that he will always lose this game (poor Bob, he always loses), so he decided to minimize
 * the score's difference. Alice's goal is to maximize the difference in the score.
 *
 * Given an array of integers stones where stones[i] represents the value of the ith stone from the left,
 * return the difference in Alice and Bob's score if they both play optimally.
 */
public class StoneGameAliceBob {
    public static void main(String[] args) {
        System.out.println(stoneGameVII(new int[] {5,3,1,4,2}));
    }
    public static int stoneGameVII(int[] stones) {
        int[][] dp = new int [stones.length][stones.length];

        int sum = Arrays.stream(stones).sum();

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(0, stones.length - 1, dp,stones,sum);
    }

    private static int solve(int left, int right, int[][] dp, int[] stones, int sum) {
        if (left == right) {
            return 0;
        }

        if (right - left == 1) {
            return Math.max(stones[right], stones[left]);
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        // What if alice chose right element to start with
        // or what if alice chose left element to start with
        return dp[left][right] = Math.max(sum - stones[left] - solve(left + 1, right,dp,stones,sum - stones[left]),
                sum - stones[right] - solve(left, right - 1,dp,stones,sum - stones[right]));

    }
}
