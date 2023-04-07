package com.techgeek.sri.arrays;


/**
 * Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data.
 * 1. The amount of petrol that every petrol pump has.
 * 2. Distance from that petrol pump to the next petrol pump.
 * Calculate the first point from where a truck will be able to complete the circle
 * (The truck will stop at each petrol pump and it has infinite capacity).
 * Expected time complexity is O(n). Assume for 1-litre petrol, the truck can go 1 unit of distance.
 * For example,
 * let there be 4 petrol pumps with amount of petrol and distance to next petrol pump value pairs as
 * {4, 6}, {7, 3} ,{6, 5},  and {4, 5}.
 * The first point from where the truck can make a circular tour is 2nd petrol pump.
 * Output should be “start = 1” (index of 2nd petrol pump)
 */

public class GasStation {
    public static void main(String[] args) {
        int [][] pumps = new int[][] {
                {4,3},
                {7,3},
                {6,5},
                {4,5}
        };

        System.out.println(findStartPosition(pumps));
    }

    private static int findStartPosition(int[][] pumps) {
        int totalPetrol = 0;
        for (int i = 0;i < pumps.length; i++) {
            totalPetrol += pumps[i][0];
        }
        int gasCapacity = 0;
        for (int i = 0;i < pumps.length; i++) {
            gasCapacity += pumps[i][1];
        }

        if (totalPetrol < gasCapacity) {
            return -1;
        }

        int total = 0, position = -1;
        for (int i = 0;i < pumps.length; i++) {
            total += pumps[i][0] - pumps[i][1];
            if (total < 0) {
                position  = i + 1;
                total = 0;
            }
        }
        return position;
    }
}
