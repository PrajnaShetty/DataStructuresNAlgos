package leetcode;

import java.io.IOException;

class DivideTwoIntegers {
    private static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        boolean negDividend = false, negDivisor = false;
        if(dividend < 0) {
            negDividend = true;
            dividend = -1 * dividend;
        }

        if (divisor < 0) {
            negDivisor = true;
            divisor = -1 * divisor;
        }

        int quotient = 0;

        if (dividend > Integer.MAX_VALUE) {
            if ((negDividend && !negDivisor) || (!negDividend && negDivisor)) {
                return Integer.MIN_VALUE;
            } else
                return Integer.MAX_VALUE;
        } else if (dividend <= Integer.MIN_VALUE) {
            if ((negDividend && !negDivisor) || (!negDividend && negDivisor)) {
                return Integer.MIN_VALUE;
            } else
                return Integer.MAX_VALUE;
        } else {

            int remainder = dividend;
            while(remainder >= divisor) {
                remainder -= divisor;
                quotient++;
            }

        }


        if ((negDividend && !negDivisor) || (!negDividend && negDivisor) ) {
            return -quotient;
        } else
            return quotient;


    }

    public static void main(String[] args) throws IOException {
            int ret = divide(2147483647, 1);

            String out = String.valueOf(ret);

            System.out.print(out);

    }
}