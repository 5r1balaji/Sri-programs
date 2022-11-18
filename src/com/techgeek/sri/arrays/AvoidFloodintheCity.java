package com.techgeek.sri.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;


/**
 *
 */
public class  AvoidFloodintheCity {

    public static void main(String[] args) {
        AvoidFloodintheCity avoidFloodintheCity = new AvoidFloodintheCity();
        int[] rains = {1,2,0,0,2,1};
        int[] ans = avoidFloodintheCity.avoidFlood(rains);
        Arrays.stream(ans).forEach((i) -> System.out.print(i+","));
    }
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        HashMap<Integer,Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        Arrays.fill(ans,1);
        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];
            if (lake > 0) {
                ans[i] = -1;
                if (fullLakes.containsKey(lake)) {
                    Integer dry = dryDays.higher(fullLakes.get(lake));
                    if (dry == null) {
                        return new int[0];
                    }
                    ans[dry] = lake;
                    dryDays.remove(dry);
                }
                fullLakes.put(rains[i],i);
            } else {
                dryDays.add(i);
            }
        }
        return ans;
    }


}
