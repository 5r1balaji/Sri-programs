package com.techgeek.sri;

import java.util.ArrayList;
import java.util.List;

/**
 * There are 3 houses .
 *     M1  M2  M3
 * H1  1   2   3
 * H2  1   2   3
 * H3  3   3   1
 *
 * Cost of building the houses by material m1, m2,m3
 * Make sure no 2 adjacent houses are built using a same material.
 *
 * Find the sum of building all the houses at lowest prices.
 *
 * The answer is  4 in the above case.
 *
 * Solution hint
 * Memoization at each level i.e At level 1 add the minimum value of cost of the previous house excluding
 * the current material
 * i.e 1,0 with 0,1 and 0,2  H2 with min of M2 and M3 in H1 when H1 is choosing M1
 * 1,1 with 0,0 and 0,2
 * 1,2 with 0,0 and 0,1
 *
 *  At first iteration , each index of previous house will have min cost combinations
 *  H2[0] [Min(M2,M3)] H1
 *  H2[1] [Min(M1,M3)] H1
 *  H2[2] [Min(M1,M2)] H1
 *
 *  At second iteration H3 will be compared to existing min combinations of H1 and H2
 *  in the previous iteration even if H2 chose H1 with same material as H3 , still they are not adjacent.
 *
 *  Index is chosen at middle index 1 so its value will never be adjacent
 *
 */
class MinimumCostHouseBuilding {

    public static void main(String[] args) {
        List<Integer> h1 = new ArrayList<>();
        h1.add(1);
        h1.add(2);
        h1.add(3);
        List<Integer> h2 = new ArrayList<>();
        h2.add(1);
        h2.add(2);
        h2.add(3);
        List<Integer> h3 = new ArrayList<>();
        h3.add(3);
        h3.add(3);
        h3.add(1);
        List<List<Integer>> cost = new ArrayList<>();
        cost.add(h1);
        cost.add(h2);
        cost.add(h3);
        System.out.println(minCost(cost));
    }

    public static int minCost(List<List<Integer>> cost) {
        List<List<Integer>> dp = new ArrayList<>();

        List<Integer> inner = new ArrayList<>();
        for (int i =0;i<cost.size();i++) {
            inner.add(i,cost.get(0).get(i));
        }
        dp.add(0,inner);
        dp.add(1,new ArrayList<>());
        dp.add(2,new ArrayList<>());

        for (int i = 1;i < cost.size();i++) {
            List<Integer> h1 = dp.get(i);
            h1.add(0,Math.min(dp.get(i-1).get(1),dp.get(i-1).get(2))+cost.get(i).get(0));
            dp.set(i,h1);

            h1.add(1,Math.min(dp.get(i-1).get(0),dp.get(i-1).get(2))+cost.get(i).get(1));
            dp.set(i,h1);

            h1.add(2,Math.min(dp.get(i-1).get(0),dp.get(i-1).get(1))+cost.get(i).get(2));
            dp.set(i,h1);
        }
        int N = cost.size();
        return Math.min(dp.get(N-1).get(0),Math.min(dp.get(N-1).get(1),dp.get(N-1).get(2)));

    }

}