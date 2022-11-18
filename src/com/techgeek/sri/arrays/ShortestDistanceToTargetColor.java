package com.techgeek.sri.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.TreeSet;

public class ShortestDistanceToTargetColor {

    public static void main(String[] args) {
        int[] arr = {1,1,2,1,3,2,2,3,3};
        int[][] queries ={
                            {1,3},
                            {2,2},
                            {6,1}
                        };
        int [] res = findShortest(arr,queries);
        Arrays.stream(res).forEach(System.out::print);
    }

    private static int[] findShortest(int[] arr, int[][] queries) {
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            TreeSet<Integer> curr = map.getOrDefault(arr[i], new TreeSet<Integer>());
            curr.add(i);
            map.put(arr[i], curr);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = findDistance(map, queries[i][0], queries[i][1]);
        }
        return res;
    }

    private static int findDistance(HashMap<Integer, TreeSet<Integer>> map, int index, int color) {
        if (map.containsKey(color)) {
            TreeSet<Integer> indices = map.get(color);
            int high ,low;
            if (indices.contains(index)) {
                return 0;
            }
            high = Optional.ofNullable(indices.higher(index)).orElse(0) - index;
            low = index - Optional.ofNullable(indices.lower(index)).orElse(Integer.MAX_VALUE);

            if (high > -1 &&  low > -1) {
                return Math.min(high, low);
            } else if (high > -1){
                return high;
            } else {
                return low;
            }
        }

        return -1;

    }
}
