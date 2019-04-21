import java.util.Arrays;

/**
 * Created by prajnashetty on 3/12/19.
 */
public class QuickSelect {

    public static void main(String args[]) {

        int[] arr = {3, 5, 2, 7, 6, 9, 4};
        System.out.println("N smallest number " + quickSelect(arr, 2));


    }

    private static int quickSelect(int[] arr, int n) {
        return quickSelect(arr, 0, arr.length - 1, n);
    }

    private static int quickSelect(int[] arr, int left, int right, int n) {

        if (left == right)
            return arr[left];

        int pivotIndex = (left + right)/2;
        pivotIndex = partition(arr, left, right, pivotIndex);

        if (n == pivotIndex) {
            return arr[n];
        } else if (n < pivotIndex){
            return quickSelect(arr, left, pivotIndex - 1, n);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, n);
        }


    }

    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];

        swap(arr, pivotIndex, right); // move pivot to end

        int l = left;
        for (int i = left ; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, l, i);
                l++;
            }
        }

        // Move pivot to its final place
        swap(arr, right, l);
        return l;
    }

    private static void swap(int[] arr, int l, int r) {

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
