package datastructures.hashtables;

/**
 * Created by prajnashetty on 2/26/19.
 */
public class DirectIndexMapping {
    final static int MAX = 1000;
    static boolean[][] has = new boolean[MAX + 1][2];

    public static void main(String[] args) {
        int[] arr = {-1, 9, -5, -8, -5, -2};

        insert(arr);

        int X = -6;
        System.out.println("Is Present = " + search(X));
    }

    private static boolean search(int x) {
        if (x >= 0)
            return has[x][0];
        else
            return has[Math.abs(x)][1];
    }

    private static void insert(int[] arr) {
        for (int a : arr) {
            if (a >= 0)
                has[a][0] = true;
            else
                has[Math.abs(a)][1] = true;
        }
    }
}
