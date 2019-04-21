package sorting;

import java.util.Arrays;
import java.util.jar.Pack200;

/**
 * Created by prajnashetty on 3/12/19.
 */
public class QuickSort {


    public static void main(String args[]) {
        int[] arr = {3, 5, 2, 7, 6, 9, 4};
        System.out.println("Quick Sorted array = " + Arrays.toString(quickSort(arr)));

        int[] arr1 = {3, 5, 2, 7, 6, 9, 4};
        quickSortOptimized(arr1);
        System.out.println("Quick Sort Optimized array = " + Arrays.toString(arr1));
    }

    private static void quickSortOptimized(int[] arr1) {
        quickSortOptimized(arr1, 0, arr1.length - 1);
    }

    private static void quickSortOptimized(int[] arr, int left, int right) {
        int pivot = arr[(left + right)/2];
        int l = left;
        int r = right;

        while(l <= r) {
            while(arr[l] < pivot) l++;

            while(arr[r] > pivot) r--;

            if (l <= r) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }

        if (left < r) {
            quickSortOptimized(arr, left, r);
        }

        if (right > l) {
            quickSortOptimized(arr, l, right);
        }
    }

    private static void swap(int[] arr, int l, int r) {

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    private static int[] quickSort(int[] arr) {

        if (arr.length < 2)
            return arr;

        int pivotIndex = arr.length / 2;
        int pivotValue = arr[pivotIndex];

        int leftCount = 0;

        //Count how many are less than the pivot
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] < pivotValue)
                leftCount++;
        }

        //Allocate arrays and cretae subsets
        int[] left = new int[leftCount];
        int[] right = new int[arr.length - leftCount - 1];

        int l = 0;
        int r = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == pivotIndex) continue;

            int val = arr[i];

            if (val < pivotValue){
                left[l++] = val;
            } else {
                right[r++] = val;
            }
        }

        //Sort the subsets
        left = quickSort(left);
        right = quickSort(right);

        //Cobine the sorted array
        System.arraycopy(left, 0 , arr, 0, left.length);
        arr[left.length] = pivotValue;
        System.arraycopy(right, 0, arr, left.length + 1, right.length);

        return arr;
    }


}
