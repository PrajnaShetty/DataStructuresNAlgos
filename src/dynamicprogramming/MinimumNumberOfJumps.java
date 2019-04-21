package dynamicprogramming;

/**
 * Created by prajnashetty on 2/17/19.
 *
 * Given an array of integers where each element represents the max number of steps that can be made forward
 * from that element.
 * Write a function to return the minimum number of jumps to reach the end of the array
 * (starting from the first element). If an element is 0, then cannot move through that element.
 */
public class MinimumNumberOfJumps {

    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int n = arr.length;

        System.out.println("Recursive -> Minimum number of jumps to reach end is "
                + minJumpsRec(arr, 0, n-1));

        System.out.println("Dynamic -> Minimum number of jumps to reach end is "
                + minJumpsDyn(arr));
    }

    private static int minJumpsDyn(int[] arr) {
        int n = arr.length;

        int[] jumps = new int[n];

        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;

        jumps[0] = 0;

        for (int i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0 ; j < i; j++ ) {
                if ( i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE)
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
            }
        }
        return jumps[n - 1];
    }

    private static int minJumpsRec(int[] arr, int l, int h) {
        if (h == l)
            return 0;

        if (arr[l] == 0)
            return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i <= h && i <= (l + arr[l]); i++) {
            int jumps = minJumpsRec(arr, i , h);

            if (jumps != Integer.MAX_VALUE && jumps + 1 < min ) {
                min = jumps + 1;
            }
        }

        return min;
    }
}
