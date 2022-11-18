package com.techgeek.sri.dynamicprogramming;

/**
 * Arrangement is considered beautiful when not more than k2 horse man stand beside a soldier
 *  1 represents soldier , 2 represents horsemen.
 *  n1 number of soldiers  n2  no. of horsemen
 *  K1 constraint of soldiers , K2 constraint of horsemen
 *  12212  22121 21221 21212 12122
 *
 *
 */
public class HorseManSoldier {
    static int limitk1,limitk2;
    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 3;
        int k1 = 2;
        int k2 = 2;
        limitk1 =k1;
        limitk2 = k2;

        System.out.println( findArrangement(n1,n2,k1,k2));
    }

    private static int findArrangement(int n1, int n2, int k1, int k2) {
        if (n1+n2 == 0) {
            return 1;
        }
        int x = 0;
        if (n1 > 0 && k1 > 0) {
           x = findArrangement(n1-1,n2,k1-1,limitk2);
        }
        int y =0;
        if (n2 > 0 && k2 > 0) {
           y = findArrangement(n1,n2-1,limitk1,k2-1);
        }
       return x+y;

    }
}
