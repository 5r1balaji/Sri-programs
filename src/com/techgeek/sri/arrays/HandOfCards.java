package com.techgeek.sri.arrays;

import java.util.PriorityQueue;

/**
 * Alice has some number of cards and she wants to rearrange the cards into groups so that each group is
 * of size groupSize, and consists of groupSize consecutive cards.
 * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize,
 * return true if she can rearrange the cards, or false otherwise.
 *
 * Example 1:
 * Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 *
 * Input: hand = [1,2,3,4,5], groupSize = 4
 * Output: false
 * Explanation: Alice's hand can not be rearranged into groups of 4.
 */
public class HandOfCards {
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(canFindGroups(hand, groupSize));
    }

    private static boolean canFindGroups(int[] hand, int groupSize) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int j : hand) {
            queue.add(j);
        }
        int groupCount = 0;
        int count = 0;
        Integer prev = null;
        while (!queue.isEmpty()) {
            if (prev == null || queue.peek() == prev + 1) {
                prev = queue.poll();
                count++;
            } else if (queue.remove(prev + 1)) {
                prev += 1;
                count++;
            } else {
                prev = null;
                count = 0;
            }


            if (count == groupSize) {
                count = 0;
                prev = null;
                groupCount++;
            }

            if (groupCount == groupSize) {
                return true;
            }

        }
        return false;
    }
}
