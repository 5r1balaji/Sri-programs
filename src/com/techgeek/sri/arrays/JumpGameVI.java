package com.techgeek.sri.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class JumpGameVI {
    public static void main(String[] args) {
        int arr[] = {1,-5,-20,4,-1,3,-6,-3};
        int s = Arrays.stream(arr).sum();
        int memo[] = new int[arr.length];
        int k = 2;
        boolean[] visited = new boolean[arr.length];
       // System.out.println(jumpGame(arr,memo,arr.length-1,k,0,visited));

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> (b[0] - a[0]));
        queue.add(new int[] {arr[0] , 0});
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            while (!queue.isEmpty()  && i - queue.peek()[1] > k) {
                queue.poll();
            }
            int curr[] = queue.peek();
            max = curr[0] + arr[i];
            queue.add(new int[] {curr[0] + arr[i], i});
        }
        System.out.println(max);
    }


    // 2 ,  0 , 0
    private static int jumpGame(int[] arr, int[] memo, int n, int k, int i, boolean[] visited) {
        if (i > n) {
            return 0;
        }
        if (visited[i]) {
            return memo[i];
        }
        if (i == n) {
            visited[i] = true;
            memo[i] = arr[n];
            return memo[i];
        }

        int max = 0;
        int[] high = new int[k + 1];
        int j = 1;

        while( (i+j) <= n && j <= k) {
            high[j] = arr[i] + jumpGame(arr, memo, n, k, (i + j), visited);

            if (j == 1) {
                max = high[j];
            }
            if (j > 1 && high[j] > high[j-1]) {
                max = high[j];
            }
            j++;
        }
        memo[i] = max;
        visited[i] = true;
        return memo[i];
    }
}
