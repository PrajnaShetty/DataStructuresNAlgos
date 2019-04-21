package dynamicprogramming;

/**
 * Created by prajnashetty on 2/17/19.
 */
public class Knapsack {

    public static void main(String args[])
    {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        
        int  W = 50;
        int n = val.length;
        
        System.out.println("Knapsack Recursive = " + knapSackRec(W, wt, val, n));

        System.out.println("Knapsack Dynamic = " + knapSackDyn(W, wt, val, n));
    }

    //O(nW) where n is the number of items and W is the capacity of knapsack.
    private static int knapSackDyn(int W, int[] wt, int[] val, int n) {

        int knapsack[][] = new int[n + 1][W + 1];

        for (int i = 0; i <= n ; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    knapsack[i][w] = 0;
                else if (wt[i - 1] <= w) {
                    knapsack[i][w] = Math.max(val[i - 1] + knapsack[i - 1][w - wt[i - 1]], knapsack[i - 1][w]);
                } else {
                    knapsack[i][w] = knapsack[i - 1][w];
                }
            }
        }

        return knapsack[n][W];
    }

    //O(2^n)
    private static int knapSackRec(int W, int[] wt, int[] val, int n) {
        // Base Case
        if (n == 0 || W == 0) {
            return 0;
        }

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n - 1] > W) {
            return knapSackRec(W, wt, val, n - 1);
        } else {
            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
            return Math.max(val[n - 1] + knapSackRec(W - wt[n - 1], wt, val, n-1), knapSackRec(W, wt, val, n- 1));
        }
    }


}
