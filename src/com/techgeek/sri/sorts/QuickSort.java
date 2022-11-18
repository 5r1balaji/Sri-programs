package com.techgeek.sri.sorts;

public class QuickSort {


    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    /**
     * The idea of Quick Sort is that you push elements below the pivot to the left corner and it need not be sorted.
     *  let say 10 70 14 25 15  ... the pivot is 15...
     *  jth index represents the element above pivot while ith index represent the last index of the element below
     *  the value of array  at pivot index.
     *
     * At first 10 <= 15  i starts with -1 meaning there are no elements below the pivot , so the interchange happens
     * b/w itself for i+1 = 0 and j = 0 i.e 10 replaced with 10 itself.
     * After i++ and j++  ,  i = 0 , j = 1
     *
     * arr[1] is 70 i.e > pivot so ignore the interchange and increment j+1 .
     * NOTE : since interchange didn't happen , i value remains the same,
     *        i.e i represent the index of last element's index below the pivot , i = 0 , arr[0] = 10 i.e less than 15
     *
     * arr[2]  = 14 is < 15 so ,  interchange  the index of next element after i with j
     *   (because i contains the element lesser than pivot but the element next to it is not lesser obviously)
     * arr [] = {10,14,70,25,15}
     *
     * arr[3] = 25 > 15 so just increment j+1
     * j = 4 ( Now the index of pivot and j becomes equal) while(j <  r) condition fails.
     *
     * NOTE : The element after ith index is obviously not lesser than pivot. So place the pivot in its respective position
     * arr[] = {10,14,15,25,70}
     *
     * The index i+1 is the index of pivot that should be returned So that the partition can be done..
     * index below the pivot and index after the pivot.
     * if (l<r) // pivot+1 = l = r  becomes same when the elements
     * int pivot = partition(arr,l,r); // this will return the i+1 position
     *  sort(arr,l,pivot-1) //
     *  sort(arr,pivot+1,r)
     *
     *
     * @param args
     */
    public static void main(String args[])
    {
        int arr[] = {70, 10, 5, 25, 15};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }

    // l and r are the first and last indexes of the array
    private void sort(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);
            sort(arr, l, pivot - 1);
            sort(arr, pivot + 1, r);
        }

    }

    private int partition(int[] arr, int l, int r) {
        int i = l - 1;
        int j = l;
        int pivot = arr[r];

        while (j < r) {
            if (arr[j] < pivot) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[j];
                arr[j++] = temp;
                i++;
            } else  j++;
        }


            int temp = arr[i + 1];
            arr[i + 1] = arr[j];
            arr[j] = temp;


        return i + 1;

    }


//    private void sort(int[] arr, int left, int right) {
//        if (left < right) {
//            int pivot = partition( arr, left, right);
//            sort(arr, left, pivot - 1);
//            sort(arr, pivot + 1, right);
//        }
//    }
//
//    private int partition(int[] arr, int left, int pivot) {
//
//        int i = left - 1;
//        int j = left;
//
//        while (j < pivot) {
//            if (arr[j] < arr[pivot]) {
//                int temp = arr[i + 1];
//                arr[i + 1] = arr[j];
//                arr[j] = temp;
//                i++;
//            }
//            j++;
//        }
//        int temp = arr[pivot];
//        arr[pivot] = arr[i + 1];
//        arr[i + 1] = temp;
//        return i + 1;
//
//    }
//

}
