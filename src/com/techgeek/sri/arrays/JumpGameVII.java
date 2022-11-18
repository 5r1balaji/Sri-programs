package com.techgeek.sri.arrays;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a 0-indexed binary string s and two integers minJump and maxJump.
 * In the beginning, you are standing at index 0, which is equal to '0'. \
 * You can move from index i to index j if the following conditions are fulfilled:
 *
 * i + minJump <= j <= min(i + maxJump, s.length - 1), and
 * s[j] == '0'.
 * Return true if you can reach index s.length - 1 in s, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "011010", minJump = 2, maxJump = 3
 * Output: true
 * Explanation:
 * In the first step, move from index 0 to index 3.
 * In the second step, move from index 3 to index 5.
 * Example 2:
 *
 * Input: s = "01101110", minJump = 2, maxJump = 3
 * Output: false
 *
 *  Solution :
 *  The idea is to iterate through each index of '0' and compare it with previous indices in queue.
 *  if at index i  the charAt(i) == '0' then check the value in queue
 *  if the index i lies bw the previous '0' the index + minJump and maxJump, then add it into the queue.
 *
 *  if (i ==  s.length - 1) i.e the final index , then compare the difference between the previous 0th index and
 *  i , if it satisfies the minJump . then we have found out that the jump is possible.
 *
 *  Also we need to remove those invalid indexes from the queue such that
 *  At index i where charAt(i) == '0'
 *  if the value in the queue + maximum jump it can make from that position is not enough reach the index i ,
 *  then there is no point of having that index in the queue.
 *  Keep popping those indices that does not match the condition at index.
 *
 *  At any point if the queue is Empty it means there is no index from which the jump can be made.
 *  Then immediately return false.
 *
 */
public class JumpGameVII {
    public static void main(String[] args) {
        String s = "00111010";
         int minJump = 3;
         int maxJump = 5;
        System.out.println(canReach(s, minJump, maxJump));
    }

    public static boolean canReach(String s, int minJump, int maxJump) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        for (int i = 1; i < s.length();i++) {
            if (s.charAt(i) == '0') {
                while(!queue.isEmpty() && queue.peek() + maxJump  < i) {
                    queue.poll();
                }
                if (queue.isEmpty()) {
                    return false;
                }
                int min  = Math.min(queue.peek() + minJump , s.length() - 1);
                int max = Math.min(queue.peek() + maxJump , s.length() - 1);
                if (i == s.length() - 1 && i - queue.peek() >= minJump) {
                    return true;
                }
                if (i >= min && i <= max) {
                    queue.add(i);
                }
            }
        }

        return false;
    }
}
