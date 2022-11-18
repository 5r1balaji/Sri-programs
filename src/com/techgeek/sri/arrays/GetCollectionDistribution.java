package com.techgeek.sri.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [ [2,3],[1,2],[2,1],[1,3],[2,4]]
 *  type 1 reprsents SET
 *  type 2 represents GET
 *
 *  N size of boolean array
 *  [false,false,false,false,false]
 *  SET will set the index with value true
 *  GET will get the nearest i.e >= index
 *
 *   output
 *  -1 2 -1
 */

 class Queues {
    int type;
    int index;

    public Queues(int type, int index) {
        this.type = type;
        this.index = index;
    }
}
public class GetCollectionDistribution {
    public static void main(String[] args) {
        List<Queues> queues = Arrays.asList(new Queues(2,3),
                                            new Queues(1,2),
                   new Queues(2,1),new Queues(1,4),new Queues(2,3));

       ArrayList<Integer> arr = getCollection(queues,5);
       arr.forEach(System.out::println);
    }

    private static ArrayList<Integer> getCollection(List<Queues> queues, int N) {
        boolean values[] = new boolean[N];
        int largest = -1;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0;i < queues.size();i++) {
            Queues k = queues.get(i);
            if (k.type == 1 && k.index-1 > largest ) {
                values[k.index -1] = true;
                largest = k.index -1;
            } else {
                if ( largest+1 >= k.index) {
                    result.add(largest+1);
                } else {
                    result.add(-1);
                }
            }
        }
        return result;
    }
}
