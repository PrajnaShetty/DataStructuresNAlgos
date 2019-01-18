package sorting;

import java.util.Arrays;

/**
 * Created by prajnashetty on 1/6/19.
 *
 * The algorithm works by selecting the smallest unsorted item and then swapping it with the item in the next position to be filled.
 The selection sort works as follows: you look through the entire array for the smallest element, once you find it you swap it (the smallest element) with the first element of the array.
 Then you look for the smallest element in the remaining array (an array without the first element) and swap it with the second element.
 Then you look for the smallest element in the remaining array (an array without first and second elements) and swap it with the third element, and so on.

 COMPLEXITY
 Best case = O(n^2)
 Worst case = O(n^2)

 Example.
 29, 64, 73, 34, 20,
 20, 64, 73, 34, 29,
 20, 29, 73, 34, 64
 20, 29, 34, 73, 64
 20, 29, 34, 64, 73

 */
public class SelectionSort {

    private static int[] selectionSort(int[] arr) {

        for (int i = 0 ; i < arr.length; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;

                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }

        }

        return arr;
    }


    public static void main(String args[]) {
        int[] arr = {3, 5, 2, 7, 6, 9, 4};
        System.out.println("Selection Sorted array = " + Arrays.toString(selectionSort(arr)));
    }


}
