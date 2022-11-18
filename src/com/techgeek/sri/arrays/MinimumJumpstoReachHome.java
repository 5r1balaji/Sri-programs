package com.techgeek.sri.arrays;

import java.util.*;

/**
 *  a is number of step forwards
 *  b is backwards
 *  x is the desired place
 *
 *  forbidden array contains list of non visitable jumps...
 *
 *  No 2 consecutive steps be backwards and position can never be negative
 *  However forward jumps can exceed X
 *
 *  x,a,b lies bw 1 and 2000
 *
 *  ex
 *  a = 3
 *  b = 1
 *  x = 9
 *  forbidden [1,2,5]
 *  ans = 3 steps
 *
 *  Solution :
 *  Similar to BFS , at each index find 2 possible options i.e forward or backwards and add the next position in
 *  the queue.
 *
 *  Time complexity :
 *  O(x)
 *
 *
 *
 */
public class MinimumJumpstoReachHome {

    public static void main(String[] args) {
        int forbidden [] =  {62,118,178,152,167,100,40,74,199,186,26,73,200,127,
                            30,124,193,84,184,36,103,149,153,9,54,154,133,95,45,
                            198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,
                            111,6,168,31,134,164,136,72,98};
        int a = 29, b = 98, x = 80;
        System.out.println(findMinimumJumps(forbidden,a,b,x));

    }

    private static int findMinimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0;i < forbidden.length;i++) {
            set.add(forbidden[i]);
        }
        Queue<String> queue = new LinkedList<>();

        queue.add("false,0,0");

        HashSet<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {

            String attributes = queue.poll();
            String[] values = attributes.split(",");
            int curr = Integer.parseInt(values[2]);
            int res = Integer.parseInt(values[1]);
            boolean isLastStepBackward = Boolean.parseBoolean(values[0]);
            if (curr == x) {
                return res;
            }
            int check = b > a ? 4000 : x;
            if (!visited.contains("false,"+ (curr + a))
                    && !set.contains(curr + a)
                    &&  curr + a - b <= check ) {
                queue.add("false," + (res + 1) + "," + (curr + a));
                visited.add("false," + (curr + a));
            }
            if (!isLastStepBackward) {
                if (!visited.contains("true," + (curr - b))
                        && curr - b >= 0
                        && !set.contains(curr - b)) {
                    queue.add("true," + (res + 1) + "," + (curr - b));
                    visited.add("true," + (curr - b));
                }
            }

        }
        return -1;
    }
}
