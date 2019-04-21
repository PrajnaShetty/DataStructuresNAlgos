package dynamicprogramming;

/**
 * Created by prajnashetty on 2/17/19.
 */
public class SubsetSum {

    // Driver code
    public static void main(String args[])
    {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = arr.length;

        System.out.println("Recursive : Subset Sum Exists ? = " + isSubsetSumRec(arr, n, sum));

        System.out.println("Dynamic : Subset Sum Exists ? = " + isSubsetSumDyn(arr, n, sum));

        System.out.println("Dynamic Space Optimized : Subset Sum Exists ? = " + isSubsetSumSpaceOptimized(arr, n, sum));

    }

    private static boolean isSubsetSumDyn(int[] arr, int n, int sum) {

        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum+1][n+1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++) {
            subset[i][0] = false;
        }

        for (int i = 1 ; i <= sum; i++) {
            for (int j = 1; j <= n ; j++) {
                subset[i][j] = subset[i][ j - 1];
                if( i >= arr[j - 1])
                    subset[i][j] = subset[i][ j - 1] || subset[ i - arr[j - 1]][j - 1];
            }
        }

        /*for (int i = 0; i <= sum; i++)
        {
            System.out.println("");
            for (int j = 0; j <= n; j++)
                System.out.print (subset[i][j] + " ");
        }*/

        return subset[sum][n];
    }

    // The problem is NP-Complete (There is no known polynomial time solution for this problem).
    private static boolean isSubsetSumRec(int[] arr, int n, int sum) {

        // Base Cases
        if (sum == 0)
             return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than
        // sum, then ignore it
        if (arr[n - 1] > sum)
            return isSubsetSumRec(arr, n - 1, sum);


        return isSubsetSumRec(arr, n - 1, sum ) || isSubsetSumRec(arr, n - 1, sum - arr[n - 1]);

    }

    private static boolean isSubsetSumSpaceOptimized(int[] arr, int n, int sum) {

        // The value of subset[i%2][j] will be true
        // if there exists a subset of sum j in
        // arr[0, 1, ...., i-1]
        boolean subset[][] = new boolean[2][sum + 1];

        for(int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    subset[i % 2][j] = true;
                } else if (i == 0) {
                    subset[i%2][j] = false;
                } else if (j >= arr[i - 1]) {
                    subset[i%2][j] = subset[(i+1)%2][j - arr[i]] || subset[(i+1)%2][j];
                } else {
                    subset[i%2][j] = subset[(i+1)%2][j];
                }
            }
        }
        return subset[n % 2][sum];
    }

}
