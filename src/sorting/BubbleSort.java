package sorting;

import java.util.Arrays;

/**
 * Created by prajnashetty on 1/6/19.
 *
 * The algorithm works by comparing each item in the list with the item next to it, and swapping them if required.
 * In other words, the largest element has bubbled to the top of the array.
 * The algorithm repeats this process until it makes a pass all the way through the list without swapping any items.
 *
 * COMPLEXITY
 * Best case = O(n)
 * Worst case = O(n^2)
 *
 *
 EXAMPLE

 7, 5, 2, 4, 3, 9
 5, 7, 2, 4, 3, 9
 5, 2, 7, 4, 3, 9
 5, 2, 4, 7, 3, 9
 5, 2, 4, 3, 7, 9
 5, 2, 4, 3, 7, 9
 */
public class BubbleSort {

    private static int[] bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }

        return arr;
    }


    public static void main(String args[]) {
        int[] arr = {3, 5, 2, 7, 6, 9, 4};
        System.out.println("Bubble Sorted array = " + Arrays.toString(bubbleSort(arr)));
    }

}
