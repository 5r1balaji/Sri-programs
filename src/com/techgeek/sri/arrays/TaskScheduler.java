package com.techgeek.sri.arrays;

import java.util.Arrays;

/**
 * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
 *
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
 *
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 *
 *
 *
 * Example 1:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 *
 *
 * Solution :
 *  Take the count of the task which repeats highest.
 *
 *  for ex : [ A,A,A,C]
 *   here count[A] = 3
 *   count[C] = 1
 *   Sort the Array count[] so that the maximum count is in the last index;
 *
 *   n is the interval for the task for maximum intervals that can occur
 *   will always be = n * highestCount - 1
 *   highestCount - 1 because the last task does not have any interval
 *
 *   for A = 3
 *   A ** A ** A <- this last A does not require interval.
 *   n = 2
 *   so number of intervals  = n * (3-1) = 2 * 2 = 4
 *
 *   so Iterate from reverse excluding the last char which ll give us the
 *   i = 24 , i --
 *
 *   so remove the minimum counts of chars that can take the idle spaces
 *   ["A","A","A","B","B","B"]
 *   max_idlespaces = 4
 *   i = 24
 *   count[A] = 3 ( maximum)
 *   remove 1  = 2            2         ,     3
 *   idlespaces = 4 - ( min(max_interval, count[B}) = 4 - 2 = 2
 *
 *  Time Complexity
 *  O(N)
 *  Since the Sorting and filling the frequencies are constant time.
 *  Its negated.
 *
 *  Space Complexity
 *  O(26)
 *
 *
 */
public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','B','B','B'};
        int n = 3;
        System.out.println(leastInterval(tasks,n));
    }
    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int [26];
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }

        Arrays.sort(freq);
        int max_interval = freq[25] - 1;
        int max_idle = n * max_interval;

        for (int i = 24; i >= 0; i--) {
            max_idle -= Math.min(max_interval, freq[i]);
        }

        return max_idle < 0 ? tasks.length : max_idle + tasks.length;
    }

}
