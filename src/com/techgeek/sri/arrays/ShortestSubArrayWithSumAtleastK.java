package com.techgeek.sri.arrays;

import java.util.ArrayDeque;


/**
 * Algorithm works based on removing the unwanted elements in the queue to shorten the length of the required array
 * as well as finding the exceeding difference at each index and subtracting the those values less than exceeding diff
 *
 * ExceedingDiff is positive and greater than the elements in the array means K is satisfied and exceeding by some diff
 * if the subarray element is not required to fulfill K . increment the left index by 1.
 *
 *
 * prefix[i] is the value summation of all the previous indices at the ith index.
 * i.e sum so far till the ith index.
 *
 * K is the required sum
 *  sumSofar - K = The required difference for the subarray
 *
 *  Queue
 *    37 48 99
 *    0  1  2
 *
 *    sumSofar[0] = 37
 *    sumSofar[1] = 85
 *    sumSofar[2] = 184
 *
 *    sumSofar-K at i = 2 is 44
 *    which clearly tells us that the subarray has items more than it requires
 *    so remove the element at front of the queue till the required value is < sumSoFar (i.e prefix)
 *
 *    sumSofar[lastinserted] >= sumSofar[i]
 *    clearly it says that value difference bw those 2 indices can never be a solution as it increases the required value
 *    i.e the index i-1 , i the last 2 values is not the required solution.
 *
 *    Idea is to remove those elements that are decreasing the sumSofar as the subarrays constructed bw the current index
 *    i and last inserted will never be the solution.
 *
 *     Ex :
 *     -100,-20,-10,100,40,-10,16
 *     k = 140
 *     sumSoFar[] = { -100,-120,-130,-30,10,0,16}
 *      At i = 0
 *      Queue[0]
 *
 *      At i = 1
 *      Queue [1]
 *      bcoz -100 > -120
 *      required = -120 - 140 = -260
 *
 *      At i = 2
 *      Queue[2]
 *      -120 > -130
 *      required = -130 - 140 = -270
 *
 *      At i = 3
 *      Queue[2,3]
 *      required = -30 -140 = -170
 *
 *      At i = 4
 *      required = 10 - 140 = -130
 *      since the first inserted value <= diff
 *      i.e -130 <= -130
 *
 *      poll(2) = Queue[3,4]
 *      res = 4 - 2 = 2
 *
 *      At i = 5
 *      10 > 0
 *      so remove 10 from queue
 *      Queue [3,5] i.e -30
 *
 *      At i = 6
 *     Queue[3,5,6]
 *
 *
 *
 *
 */
public class ShortestSubArrayWithSumAtleastK {
    public static void main(String[] args) {
        int arr[] = {-100,-20,-10,100,40,-10,16};
        int k = 140;
        int res = findShort(arr,k);
        System.out.println(res);
    }

    private static int findShort(int[] nums, int k) {
        int res = -1;
        int[] sumSoFar = new int[nums.length];
        sumSoFar[0] = nums[0];
        for (int i = 1;i < nums.length;i++) {
            sumSoFar[i] = sumSoFar[i - 1] + nums[i];
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (sumSoFar[i] >= k) {
                if (res == -1) {
                    res = i+1;
                } else {
                    res = Math.min(res,i+1);
                }
            }

            //When the difference is positive and is greater the sumSofar at i th  previous indices
            // it means the sumSofar at current index i already satisfies K
            int exceedingDiff = sumSoFar[i] - k; //Exceeding diff from K
            // if the sumsofar at previous indices < exceedDiff remove that and get the subarray count as i+1 to curr Index
            // pollFirst() returns the index of the negated value so naturally the difference is 1 more than the required index
            while (!queue.isEmpty() && sumSoFar[queue.peekFirst()] <= exceedingDiff) {
                if (res == -1) {
                    res = i - queue.pollFirst();
                } else {
                    res = Math.min(res,i - queue.pollFirst());
                }
            }

            while (!queue.isEmpty() && sumSoFar[queue.peekLast()] >= sumSoFar[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
        }


        return res;
    }
}
