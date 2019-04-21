package dynamicprogramming;

/**
 * Created by prajnashetty on 2/13/19.
 *
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

 */
public class LongestCommonSubsequence {

    //O(2^n)
    private int lcsRec(char[] x, char[] y, int m, int n ) {
        if (m == 0 || n == 0)
            return 0;
        if (x[m-1] == y[n-1]) {
            return 1 + lcsRec(x, y , m-1, n-1);
        } else {
            return Math.max(lcsRec(x, y, m-1, n), lcsRec(x, y , m, n-1));
        }
    }

    // O(mn)
    private void lcsDyn(char[] x, char[] y, int m, int n) {
        int[][] table = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }

            }
        }

        //print LCS
        int index = table[m][n];
        int temp = index;

        char[] result = new char[index + 1];
        result[index] = ' ';

        // Start from the right-most-bottom-most corner and
        // one by one store characters in result[]

        int i = m, j = n;

        while( i > 0 && j > 0) {
            if (x[i - 1] == y[j - 1])  {
                result[index - 1] = x[i - 1];
                i--; j--;
                index--;
            } else if (table[i - 1][j] > table[i][j - 1])
                i--;
            else {
                j--;
            }
        }

        System.out.print("LCS of "+ String.valueOf(x) +" and "+ String.valueOf(y) +" is ");
        for(int k=0;k<=temp;k++)
            System.out.print(result[k]);
    }



    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();

        System.out.println("Recursive LCS length = " + lcs.lcsRec(x,y, x.length, y.length));

        lcs.lcsDyn(x,y, x.length, y.length);

    }
}
