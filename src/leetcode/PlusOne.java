package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class PlusOne {
    private static int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int carryover = 1;
        for (int i = digits.length - 1; i <= 0 ; i--) {
            stack.push((digits[i] + carryover) % 10);
            carryover = (digits[i] + carryover) / 10;
        }

        int[] newDigits = new int[stack.size()];
        int i = 0;
        while(!stack.empty()) {
            newDigits[i++] = stack.pop();
        }

        return newDigits;
    }

    private static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    private static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    private static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] digits = stringToIntegerArray(line);

            int[] ret = plusOne(digits);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}