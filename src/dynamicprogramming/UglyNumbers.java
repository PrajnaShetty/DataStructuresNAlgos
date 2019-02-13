package dynamicprogramming;

/**
 * Created by prajnashetty on 2/1/19.
 *
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
 * The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers.
 * By convention, 1 is included.
 *
 * Algorithmic Paradigm: Dynamic Programming
 Time Complexity: O(n)
 Auxiliary Space: O(n)
 */
public class UglyNumbers {


    public static void main(String[] args) {
        UglyNumbers uglyNumbers = new UglyNumbers();

        //Simple Method
        int n = 150;
        int result1 = getNthUglyNumbersSimple(n);
        System.out.println("Simple Result = " + result1);

        //Dynamic Method

        int result2 = getNthUglyNumbersDynamic(n);
        System.out.println("Dynamic Result = " + result2);
    }

    private static int getNthUglyNumbersDynamic(int n) {

        int[] ugly = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;
        int nextUglyNum = 1;

        ugly[0] = nextUglyNum;

        for (int i = 1; i < n ; i++) {
            nextUglyNum = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5)) ;

            ugly[i] = nextUglyNum;

            if (nextUglyNum == nextMultipleOf2) {
                nextMultipleOf2 = ugly[++i2] * 2;
            }

            if (nextUglyNum == nextMultipleOf3) {
                nextMultipleOf3 = ugly[++i3] * 3;
            }

            if (nextUglyNum == nextMultipleOf5) {
                nextMultipleOf5 = ugly[++i5] * 5;
            }

        }

        return nextUglyNum;

    }

    private static int getNthUglyNumbersSimple(int n) {
        int i = 1;
        int count = 1;
        while(count < n) {
            i++;

            if (isUgly(i))
                count++;

        }

        return i;
    }

    private static boolean isUgly(int num) {
        num = maxDivide(num, 2);
        num = maxDivide(num, 3);
        num = maxDivide(num, 5);

        return (num == 1);

    }

    private static int maxDivide(int num, int i) {

        while(num % i == 0)
            num = num/i;

        return num;
    }
}
