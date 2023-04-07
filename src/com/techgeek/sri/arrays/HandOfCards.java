package com.techgeek.sri.arrays;

import java.util.*;

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
        int[] hand = {1,2,2,3};
        int groupSize = 2;
        //System.out.println(canFindGroups(hand, groupSize));
        System.out.println(canFindGroups1(hand, groupSize));
    }
    // 1 2 2 3 3 4 6 7 8
    private static boolean canFindGroups1(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> orderedHands = new TreeMap<>();
        Arrays.stream(hand).forEach(i -> orderedHands.put(i, orderedHands.getOrDefault(i,0) + 1));
        int groupsFound = 0;
        Queue<Integer> handCollection = new LinkedList<>();

            while (!orderedHands.keySet().isEmpty()) {
                if (handCollection.isEmpty()) {
                    Integer current = orderedHands.firstKey();
                    if (current == null) {
                        return false;
                    }
                    handCollection.add(current);
                    updateHands(orderedHands, current);
                } else {
                    Integer next = orderedHands.higherKey(handCollection.peek());
                    if (next == null) {
                        return false;
                    }
                    handCollection.add(next);
                    updateHands(orderedHands, next);
                }

                if (handCollection.size() == groupSize) {
                    groupsFound++;
                    handCollection.clear();
                }
                if (groupsFound == groupSize) {
                    return true;
                }
            }
            return false;
        //}
    }

    private static void updateHands(TreeMap<Integer, Integer> orderedHands, Integer current) {
        Integer count = orderedHands.get(current);
        if (count - 1  == 0) {
            orderedHands.remove(current);
        }
        else orderedHands.put(current, count - 1);
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
