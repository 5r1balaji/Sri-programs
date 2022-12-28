package com.techgeek.sri;



import java.util.*;
import java.util.function.Supplier;
/*
*//**
 *
 * Suppose we have an unsorted log file of accesses to web resources.
 * Each log entry consists of an access time, the ID of the user making the access, and the resource ID.
 *
 * The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.
 *
 * Examples:
 * logs1 = [
 *     ["200", "user_1", "resource_5"],
 *     ["3", "user_1", "resource_1"],
 *     ["620", "user_1", "resource_1"],
 *     ["620", "user_3", "resource_1"],
 *     ["34", "user_6", "resource_2"],
 *     ["95", "user_9", "resource_1"],
 *     ["416", "user_6", "resource_1"],
 *     ["58523", "user_3", "resource_1"],
 *     ["53760", "user_3", "resource_3"],
 *     ["58522", "user_22", "resource_1"],
 *     ["100", "user_3", "resource_6"],
 *     ["400", "user_6", "resource_2"],
 * ]
 *
 * logs2 = [
 *     ["357", "user", "resource_2"],
 *     ["1262", "user", "resource_1"],
 *     ["1462", "user", "resource_2"],
 *     ["1060", "user", "resource_1"],
 *     ["756", "user", "resource_3"],
 *     ["1090", "user", "resource_3"],
 * ]
 *
 * logs3 = [
 *     ["300", "user_10", "resource_5"],
 * ]
 *
 * logs4 = [
 *     ["1", "user_96", "resource_5"],
 *     ["1", "user_10", "resource_5"],
 *     ["301", "user_11", "resource_5"],
 *     ["301", "user_12", "resource_5"],
 *     ["603", "user_12", "resource_5"],
 *     ["1603", "user_12", "resource_7"],
 * ]
 *  key
 *  key + windowLimit)
 * resource5 - 1 + 300 - 3. (timestamp <= 301)  4
 *             301+ 300 = 601 - 2
 *             903 - 1
 *             1903 - 1
 *
 *
 * Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.
 *
 * Expected Output:
 * most_requested_resource(logs1) # => ('resource_1', 3) [resource_1 is accessed at 416, 620, 620]
 * most_requested_resource(logs2) # => ('resource_1', 2) [resource_1 is accessed at 1060, 1262]
 * most_requested_resource(logs3) # => ('resource_5', 1) [resource_5 is accessed at 300]
 * most_requested_resource(logs4) # => ('resource_5', 4) [resource_5 is accessed at 1, 1, 301, 301]
 *
 *
 * Solution:
 * Sort the input in the order of timestamps and then use queue to remove the elements as and when they exceed
 * their 5 min limit i.e lets assume queue has [1,58,301] when 302 comes it checks with the queue.peek()
 * and removes the element from the queue
 */
public class LogPrinting {
    public static void main(String[] args) {
     String[][] logs = {
                {"1", "user_96", "resource_5"},
                {"302", "user_11", "resource_5"},
                {"301", "user_11", "resource_5"},
                {"58", "user_10", "resource_5"},
                {"358", "user_12", "resource_5"},
                {"602", "user_12", "resource_5"},
                {"1603", "user_12", "resource_7"}
        };

        String[][] logs3 = {
                {"416", "user_6", "resource_1"},
                {"200", "user_1", "resource_5"},
                {"3", "user_1", "resource_1"},
                {"620", "user_1", "resource_1"},
                {"620", "user_3", "resource_1"},
                {"34", "user_6", "resource_2"},
                {"95", "user_9", "resource_1"},

                {"58523", "user_3", "resource_1"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_22", "resource_1"},
                {"100", "user_3", "resource_6"},
                {"400", "user_6", "resource_2"}
        };

        String[][] logs4 = {
                {"357", "user", "resource_2"},
                {"1262", "user", "resource_1"},
                {"1462", "user", "resource_2"},
                {"1060", "user", "resource_1"},
                {"756", "user", "resource_3"},
                {"1090", "user", "resource_3"}
        };

        String[][] logs2 = {
                {"300", "user_10", "resource_5"}
        };


        Pair<String, Integer> pair = most_requested_resource(logs);
        System.out.println(pair.getKey()+","+pair.getValue());

        Pair<String, Integer> pair1 = most_requested_resource(logs3);
        System.out.println(pair1.getKey()+","+pair1.getValue());

        Pair<String, Integer> pair2 = most_requested_resource(logs4);
        System.out.println(pair2.getKey()+","+pair2.getValue());

        Pair<String, Integer> pair3 = most_requested_resource(logs2);
        System.out.println(pair3.getKey()+","+pair3.getValue());
    }



    private static Pair<String, Integer> most_requested_resource(String[][] logs) {
        Arrays.sort(logs, Comparator.comparingInt(log -> Integer.parseInt(log[0])));

        Map<String, Queue<Integer>> resourceCounts = new HashMap<>();
        String maxResource = "";
        int maxCount = 0, windowLimit = 300;

        for (String[] log : logs) {
            int time = Integer.parseInt(log[0]);
            String resource = log[2];

            if (resourceCounts.containsKey(resource)) {
                Queue<Integer> logQueue = resourceCounts.get(resource);
                while (!logQueue.isEmpty() && time > logQueue.peek() + windowLimit ) {
                    logQueue.poll();
                }
                logQueue.add(time);
                if (maxCount < logQueue.size()) {
                    maxCount = logQueue.size();
                    maxResource = resource;
                }
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(time);
                resourceCounts.put(resource, list);
                if (maxResource.isEmpty()) {
                    maxResource = resource;
                    maxCount = 1;
                }
            }
        }

        return new Pair<>(maxResource, maxCount);

    }
}

class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getKey() {
        return first;
    }

    public U getValue() {
        return second;
    }
}
