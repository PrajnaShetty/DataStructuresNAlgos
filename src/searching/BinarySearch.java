package searching;

/**
 * Created by prajnashetty on 1/11/19.
 *
 *
 Recursive
 Time Complexity : O(log n)
 Space Complexity : O(log n)

 Iterative
 Time Complexity : O(log n)
 Space Complexity : O(1)
 */
public class BinarySearch {

    public static void main(String args[]) {
        int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};
        int x = 144;

        int index = recursiveBinarySearch(arr, 0 , arr.length - 1,  x);

        System.out.println("\nRecursive : Number " + x + " is at index " + index);

        index = iterativeBinarySearch(arr, x);

        System.out.println("\nIterative: Number " + x + " is at index " + index);
    }

    private static int iterativeBinarySearch(int[] arr, int x) {
        int low = 0, high = arr.length;

        while (low <= high ) {
            int mid = (low + high)/2;
            if (arr[mid] == x)
                return mid;

            if (x < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private static int recursiveBinarySearch(int[] arr, int low, int high, int x) {
        if (high >= low) {
            int mid = (low + high)/2;

            if (arr[mid] == x)
                return mid;

            if (x < arr[mid])
                return recursiveBinarySearch(arr, low, mid - 1, x);
            else
                return recursiveBinarySearch(arr, mid + 1, high, x);
        }

        return -1;
    }
}
