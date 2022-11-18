package com.techgeek.sri.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * if the number of characters in the array > k
 * i.e be it nums1 or nums2 if the required K is lesser than the number of elements in the array
 * It means that the greater number can be formed choosing 0 elements from array 1 and 5 elements from array 2
 *  k - nums2.length
 *  will give us how many elements can be chosen minimum from array 1 i.e nums1
 *  if num2.length > k it means 0 elements at the least ca
 * i = k - nums2.length
 * k - i is the maximum element that can chosen from nums2
 *
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [3,4,6,5], nums2 = [9,1,2,5,8,3], k = 5
 * Output: [9,8,6,5,3]
 *
 */
public class CreateMaximumNumber {
    public static void main(String[] args) {
        int[] nums1 = {8,7,5,2,1};
        int[] nums2 = {6,4,7};
        int k = 5;
        Arrays.stream(maxNumber(nums1,nums2,k)).forEach(System.out::print);
    }

    private static int[] createMax(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int m = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && st.size() + (m - i) > k && st.peek() < nums[i]) {
                st.pop();
            }
            if (st.size() < k) {
                st.add(nums[i]);
            }
        }
        int[] res = new int [st.size()];
        int i = st.size() - 1;
        while (!st.isEmpty()) {
            res[i--] = st.pop();
        }
        return res;
    }
    public static  int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] max = new int[k];
        if (nums1.length + nums2.length < k) {
            return max;
        }
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(nums1.length, k); i++) {
            int[] current = merge(createMax(nums1, i), createMax(nums2, k - i));
            if (greater(current, 0, max, 0)) {
                max = current;
            }
        }

        return max;
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < res.length) {
            if (greater(nums1,j,nums2,k)) {
                res[i++] = nums1[j++];
            } else {
                res[i++] = nums2[k++];
            }
        }
        return res;
    }

    private static boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                return true;
            } else if (nums1[i] == nums2[j]){
                i++;
                j++;
            } else {
                return  false;
            }
        }
        if (i < nums1.length) {
            return true;
        }
        return false;
    }
}
