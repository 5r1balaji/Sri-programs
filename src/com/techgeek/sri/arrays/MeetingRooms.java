package com.techgeek.sri.arrays;

import java.util.HashMap;

public class MeetingRooms {

    public static void main(String[] args) {
        int[][] intervals ={{20,45},{12,13},{2,50},{14,20},{3,5}};
        System.out.println(findRooms(intervals));
    }

    public static int findRooms(int[][] intervals) {
        HashMap<Integer,Integer[]> map = new HashMap<>();
        int meetings = 0;
        for (int i = 0; i < intervals.length;i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (map.size() > 0) {
                boolean isFound = false;
                for (int j = 1; j <= map.size(); j++) {
                    Integer[] k = map.get(j);
                    if (start >= k[0] && start < k[1] ) {
                        continue;
                    }

                    if (start < k[0] && (end > k[1] || end > k[0])) {
                        continue;
                    }
                    k[0] = Math.min(start,k[0]);
                    k[1] = Math.max(end, k[1]);
                    map.put(j, k);
                    isFound = true;
                    break;
                }

                if (!isFound) {
                    Integer[] k = new Integer[2];
                    k[0] = start;
                    k[1] = end;
                    map.put(++meetings,k);
                }

            } else {
                Integer[] k = new Integer[2];
                k[0] = start;
                k[1] = end;
                map.put(++meetings,k);
            }

        }

        return map.size();
    }
}
