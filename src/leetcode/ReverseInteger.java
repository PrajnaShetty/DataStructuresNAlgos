package leetcode;

import java.io.IOException;
import java.util.Stack;

class ReverseInteger {
    private static int reverse(int x) {
        Stack<Integer> myNumbers = new Stack<>();
        boolean neg = false;

        if (x < 0) {
            neg = true;
            x = -x;
        }

        int rem = x;
        while(rem >= 0) {
            myNumbers.add(rem % 10);
            rem = rem / 10;
            if (rem < 10) {
                if (rem > 0) {
                    myNumbers.add(rem);
                }
                break;
            }


        }

        long result = 0, i = 0;
        while(!myNumbers.empty()) {
            System.out.println("(myNumbers.peek()  = " + myNumbers.peek());
            result += myNumbers.pop() * Math.pow(10, i);
            System.out.println("result  = " + result);
            if (result > (Math.pow(2, 31) - 1)) {
                return 0;
            }
            i++;
        }

        if (neg) {
            result = -result;
        }
        return (int) result;
    }

    public static void main(String[] args) throws IOException {

    int ret = reverse(1534236469);

    String out = String.valueOf(ret);

    System.out.print(out);

    }
}