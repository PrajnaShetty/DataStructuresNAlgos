package sorting;

import java.util.Arrays;

/**
 * Created by prajnashetty on 1/6/19.
 *
 * To sort unordered list of elements, we remove its entries one at a time and then insert each of them into a sorted part (initially empty):

 * COMPLEXITY
 * Best case = O(n)
 * Worst case = O(n^2)
 *
 *
 */
public class InsertionSort {

    private static int[] insertionSort(int[] arr) {
        for (int i = 1 ; i < arr.length; i++) {
            int index = arr[i];
            int j = i;

            while (j > 0 && arr[j - 1] > index) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = index;
        }
        return arr;
    }

    public static void main(String args[]) {
        int[] arr = {3, 5, 2, 7, 6, 9, 4};
        System.out.println("Insertion Sorted array = " + Arrays.toString(insertionSort(arr)));
    }


}
