package com.techgeek.sri.arrays;

public class Medianof2SortedArrays {


    public static void main(String[] args) {
        int nums1[] = {1,3};
        int nums2[] = {4,5};
        double res = findMedianSortedArrays(nums1,nums2);
        System.out.println(res);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;
        int sum = l1 + l2;
        int medianCount = 0;
        boolean isEven =  sum % 2 == 0;

        int median = sum / 2;
        double res = 0.0;

        int i = 0,j=0;

        if (!isEven) {
            while (medianCount != median+1) {
                if (nums1[i] < nums2[j] ){
                    medianCount++;
                    if (medianCount == median+1) {
                        res = nums1[i];
                    }

                    i++;
                }
                else {

                    medianCount++;
                    if (medianCount == median+1) {
                        res = nums2[j];
                    }

                    j++;
                }


            }
        } else {
            while (medianCount != median+1) {
                if (i < l1 && nums1[i] < nums2[j] ){

                    medianCount++;
                    if (medianCount == median) {
                        res = nums1[i];
                    } else if (medianCount == median+1) {
                        res = (res + nums1[i])/2;
                    }

                    i++;
                }
                else {

                    medianCount++;
                    if (medianCount == median) {
                        res = nums2[j];
                    } else if (medianCount == median+1) {
                        res = (res + nums2[j])/2;
                    }

                    j++;
                }
            }
        }

        return res;

    }
}
