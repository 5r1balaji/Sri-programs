package com.techgeek.sri.arrays;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * At Booking.com our customer service team is an important contributor to customer satisfaction.
 * During busy times, however, there might be more calls to customer service than the number of customer service
 * executives can manage. Fortunately, we record data on that. We've collected information about all phone calls to our
 * call centres for the past year.
 * Given that our current number of customer care agents is X.
 * Determine how many more people we would need to hire,
 * to make sure that our customers would not have to wait during peak hours
 * (i.e. that we don't have more phone calls than we have customer service executives).
 * Input:
 * The first line contains the current number of customer service executives X.
 * The second line contains an integer N, which is the number of data points in the data set.
 * The next N lines are whitespace-separated pairs of timestamps
 * (a timestamp is an integer that represents seconds since the epoch).
 * On each line, the first time is the time when the call was started, and the second one is when that call ended.
 * Output:
 * A single integer, representing the number of additional customer service executives
 * that we would need to employ, to cover the call volume during peak times.
 * If the current coverage is already sufficient, then print 0.
 * Sample input:
 * 1
 * 3
 * 1481122000 1481122020
 * 1481122000 1481122040
 * 1481122030 1481122035
 * Sample output:
 * 1
 * Explanation:
 * The first call overlaps with the second call. The third call also overlaps with the second call.
 * However, the first and the third call are not overlapping with each other
 *
 *
 * Solution:
 *  The solution consists of 2 parts i.e Iterate
 *  1. Sorting the timestamp in the order of the start time and end time and iterate the timestamps.
 *  2. Check if there is any outstanding agent who finished the call i.e The End time of previous call ends before the
 *      new start time.
 *     2.1  If there exists a timestamp in the TreeSet who finishes before the new start time .Then remove the entry
 *     from the TreeSet i.e meaning The entry no longer exists because that employee is now assigned to a new call.
 *     2.2 If there does not exist a timestamp who cannot finish the previous call before new start time, then either a
 *     new agent needs to be assigned which can be identified by reducing the No_Of_Agents by -1 or
 *     adding extra workforce. i.e Required_Agents++
 *
 *     TimeComplexity
 *     O(N Log(N)) + O(N Log(N)) Because of adding new element into the TreeSet and sorting.
 *     Space Complexity
 *     O(N)
 */
public class CustomerServiceCapacity {
    public static void main(String[] args) {
        int noOfAgents = 1;
        long[][] timeStamps = {
                {1481122030, 1481122035},
                {1481121999, 1481122020},
                {1481121999, 1481122025},
                {1481122002, 1481122040},

        };
        System.out.println(isCapacitySufficient(noOfAgents, timeStamps));
    }

    private static int isCapacitySufficient(int noOfAgents, long[][] timeStamps) {
        int requiredAgent = 0;
        Arrays.sort(timeStamps, (o1, o2) -> (int) (o1[0] - o2[0]));
        TreeSet<Long> agentAvailabilityWindow = new TreeSet<>();
        for (long[] timestamp : timeStamps) {
            long start = timestamp[0];
            long end = timestamp[1];
            Long availableAgent = agentAvailabilityWindow.lower(start);
            if (availableAgent == null && noOfAgents > 0) {
                noOfAgents--;
            } else if (availableAgent == null && noOfAgents == 0 ) {
                requiredAgent++;
            }else {
                agentAvailabilityWindow.remove(availableAgent);
            }
            agentAvailabilityWindow.add(end);
        }
        return requiredAgent;
    }
}
