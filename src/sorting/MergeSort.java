package sorting;

import java.util.Arrays;

/**
 * Created by prajnashetty on 1/6/19.
 */
public class MergeSort {

    private static void mergeSort(int[] arr, int n) {
        if (n < 2)
            return;

        int mid = n/2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }

        for (int i = mid; i < n; i++) {
            rightArr[i - mid] = arr[i];
        }

        mergeSort(leftArr, mid);
        mergeSort(rightArr, n - mid);

        merge(arr, leftArr, mid, rightArr, n-mid);
    }

    private static void merge(int[] arr, int[] leftArr, int left, int[] rightArr, int right) {
        int i = 0, j = 0, k = 0;

        while(i < left && j < right) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }

        }

        while (i < left) {
            arr[k++] = leftArr[i++];
        }

        while (j < right) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void main(String args[]) {
        int[] arr = {3, 5, 2, 7, 6, 9, 4};
        mergeSort(arr, arr.length);
        System.out.println("Merge Sorted array = " + Arrays.toString(arr));
    }


}
