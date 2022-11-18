package com.techgeek.sri.arrays;

public class SplitArraysWithSameAvg {

    public static void main(String[] args) {
        int nums[] ={1,2,3,4,5,6,7,8};
        System.out.println(splitArraySameAverage(nums));
    }

    public static boolean splitArraySameAverage(int[] nums) {
        int rem = 0;
        for (int i =0;i<nums.length;i++) {
            rem += nums[i];
        }
        //System.out.println(rem-1/(double)(4));
        return isSplitAverage(0,0,rem,nums,0);

    }

    public static boolean isSplitAverage(int i,int sum, int rem,int nums[],int count) {
        boolean result = false;
        while (count < nums.length - i && !result) {
                sum += nums[i];
                count++;
                rem = rem - nums[i];

            if (count == nums.length/2 ) {
               if ( rem/(double)(nums.length/2) == sum/(double)(nums.length/2)) {
                    return true;
                } else {
                   sum -= nums[i];
                   rem += nums[i];
                   count--;
               }
            }
                i++;
             result = isSplitAverage(i,sum,rem,nums,count);

        }


        return result;


    }
}
