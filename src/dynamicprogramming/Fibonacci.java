package dynamicprogramming;

/**
 * Created by prajnashetty on 1/31/19.
 */
public class Fibonacci {

    private final int MAX = 100;
    private final int NIL = -1;

    private int[] lookup = new int[MAX];

    void initialize() {
        for (int i = 0; i < MAX; i++) {
            lookup[i] = NIL;
        }
    }


    int fibMemorization(int n) {
        if (lookup[n] == NIL) {
            if (n <= 1) {
                lookup[n] = n;
            } else {
                lookup[n] = fibMemorization(n - 1) + fibMemorization(n - 2);
            }
        }

        return lookup[n];
    }

    int fibTabulation(int n) {
        lookup = new int[n + 1];

        lookup[0] = 0;
        lookup[1] = 1;

        for (int i = 2; i <= n ; i++) {
            lookup[i] = lookup[i - 1] + lookup[i - 2];
        }

        return lookup[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int n = 40;

        fibonacci.initialize();
        System.out.println("Result of memorization = " + fibonacci.fibMemorization(n));

        System.out.println("Result of tabulation = " + fibonacci.fibTabulation(n));
    }
}
