package dynamicprogramming;

/**
 * Created by prajnashetty on 2/1/19.
 *
 * A binomial coefficient C(n, k) also gives the number of ways, disregarding order, that k objects can be chosen from among n objects; more formally,
 * the number of k-element subsets (or k-combinations) of an n-element set.
 *
 * Dynamic1
 Time Complexity: O(n*k)
 Auxiliary Space: O(n*k)

 Dynamic SpaceOptimized
 Time Complexity: O(n*k)
 Auxiliary Space: O(k)
 
 */
public class BinomialCoefficient {
    public static void main(String[] args) {
        int n = 4, k = 2;

        System.out.println("Recursive : Binomial Coefficient : " + findBinomialCoefficientRecursive(n, k));

        System.out.println("Dynamic : Binomial Coefficient : " + findBinomialCoefficientDynamic1(n, k));

        System.out.println("Dynamic SpaceOptimized : Binomial Coefficient : " + findBinomialCoefficientDynamic2(n, k));
    }

    private static int findBinomialCoefficientDynamic2(int n, int k) {
        int[] binCo = new int[k + 1];

        binCo[0] = 1;

        for (int i = 1; i <= n ; i++) {
            for (int j = Math.min(i, k); j > 0 ; j--) {
                binCo[j] = binCo[j] + binCo[j - 1];
            }
        }

        return binCo[k];
    }

    private static int findBinomialCoefficientDynamic1(int n, int k) {
        int[][] binCo = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {

                if (j == 0 || j == i) {
                    binCo[i][j] = 1;
                } else {
                    binCo[i][j] = binCo[i-1][j-1] + binCo[i-1][j];
                }
            }
        }

        return binCo[n][k];
    }

    private static int findBinomialCoefficientRecursive(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }

        return findBinomialCoefficientRecursive(n - 1, k - 1) + findBinomialCoefficientRecursive(n - 1, k);
    }
}
