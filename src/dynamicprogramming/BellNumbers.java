package dynamicprogramming;

/**
 * Created by prajnashetty on 2/1/19.
 *
 * Given a set of n elements, find number of ways of partitioning it.
 Examples:

 Input:  n = 2
 Output: Number of ways = 2
 Explanation: Let the set be {1, 2}
 { {1}, {2} }
 { {1, 2} }

 Input:  n = 3
 Output: Number of ways = 5
 Explanation: Let the set be {1, 2, 3}
 { {1}, {2}, {3} }
 { {1}, {2, 3} }
 { {2}, {1, 3} }
 { {3}, {1, 2} }
 { {1, 2, 3} }.

 Let S(n, k) be total number of partitions of n elements into k sets. The value of n’th Bell Number is sum of S(n, k) for k = 1 to n.

 Bell(n) =  \sum_{k=0}^{n}S(n,k)

 Value of S(n, k) can be defined recursively as, S(n+1, k) = k*S(n, k) + S(n, k-1)

 First few Bell numbers are 1, 1, 2, 5, 15, 52, 203, …

 Using Bell Triangle Method - https://en.wikipedia.org/wiki/Bell_triangle

 // If this is first column of current row 'i'
 If j == 0
 // Then copy last entry of previous row
 // Note that i'th row has i entries
 Bell(i, j) = Bell(i-1, i-1)

 // If this is not first column of current row
 Else
 // Then this element is sum of previous element
 // in current row and the element just above the
 // previous element
 Bell(i, j) = Bell(i-1, j-1) + Bell(i, j-1)

 Time Complexity of this solution is O(n^2).

 */
public class BellNumbers {
    public static void main(String[] args) {
        for(int n = 1; n <= 5; n++) {
            System.out.println("Bell Number for " + n + " : " + findBellNumber(n));
        }
    }

    private static int findBellNumber(int n) {
        int[][] bell = new int[n + 1][n + 1];
        bell[0][0] = 1;

        for (int i = 1; i <= n ; i++) {
            bell[i][0] = bell[i-1][i-1];

            for(int j = 1; j <= i ; j++) {
                bell[i][j] = bell[i-1][j-1] + bell[i][j-1];
            }
        }

        return bell[n][0];

    }
}
