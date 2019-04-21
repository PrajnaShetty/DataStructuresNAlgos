package dynamicprogramming;

import java.util.Arrays;

/**
 * Created by prajnashetty on 2/13/19.
 *
 * Given a value N, if we want to make change for N cents,
 * and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */

//different from leetcode coin change
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int total = 4;

        System.out.println("Recursive coin change = " + countChangeRec(coins, coins.length, total));

        System.out.println("Dynamic coin change = " + countChangeDyn(coins, coins.length, total));

    }

    private static int countChangeRec(int[] coins, int length, int total) {
        // If n is 0 then there is 1 solution
        // (do not include any coin)
        if (total == 0)
            return 1;

        // If n is less than 0 then no
        // solution exists
        if (total < 0)
            return 0;

        // If there are no coins and n
        // is greater than 0, then no
        // solution exist
        if (length <= 0 && total > 0)
            return 0;

        // count is sum of solutions (i)
        // including S[m-1] (ii) excluding S[m-1]
        return countChangeRec(coins, length - 1, total) + countChangeRec(coins, length, total - coins[length - 1]);
    }

    //Time complexity of this function: O(mn)
    //Space Complexity of this function: O(n)
    private static int countChangeDyn(int[] coins, int length, int total) {
        int[] table = new int[total + 1];

        table[0] = 1;

        for (int i = 0; i < length; i++) {
            for (int j = coins[i]; j <=  total; j++) {
                table[j] += table[j - coins[i]];
            }
        }


        System.out.println(Arrays.toString(table));
        return table[total];

    }
}
