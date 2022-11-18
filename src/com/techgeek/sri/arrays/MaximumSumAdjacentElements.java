package com.techgeek.sri.arrays;


/**
 * Maximum sum such that no two elements are adjacent
 * Input : arr[] = {25, 5, 10, 100, 10, 5}
 * Output : 130
 *
 * Input : arr[] = {1, 2, 3}
 * Output : 4
 *
 * Input : arr[] = {1, 20, 3}
 * Output : 20
 *
 *
 * Solution :
 * Add the index by 1 when the adjacent elements are greater
 *  Add the index value when the current element is greater than its adjacent and increment the index by 2.
 */
public class MaximumSumAdjacentElements {

    public static void main(String[] args) {
        int arr[] = {25, 35, 10, 100, 0, 5};
        //int arr[] = {1, 2, 3};
        int index = 0;
        int sum1 = findMax(index+2,arr[index++],arr);
        int sum2 = findMax(index+2,arr[index],arr);
        System.out.println(Math.max(sum1,sum2));
    }

    static int findMax(int index ,int sum ,int arr []) {

        while (index <= arr.length -1) {
            if (index+1 < arr.length && arr[index+1] > arr[index]) {
                index +=1 ;
            } else {
                sum += arr[index];
                index += 2;
            }
        }

        return sum;
    }




}
