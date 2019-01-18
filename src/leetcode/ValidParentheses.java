package leetcode;

import java.io.IOException;
import java.util.Stack;

class ValidParentheses {
    private static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();

        String openBrackets = "{([";
        String bracket, poppedBracket;
        for(int i = 0; i < s.length(); i++) {
            bracket = Character.toString(s.charAt(i));
            if (openBrackets.contains(bracket)) {
                stack.push(bracket);
            } else {
                if (!stack.empty()) {
                    poppedBracket = stack.pop();
                    if (bracket == "}" && poppedBracket != "{")
                        return false;
                    else if (bracket == "]" && poppedBracket != "[")
                        return false;
                    else if (bracket == ")" && poppedBracket != "(")
                        return false;
                }
                else {
                    return false;
                }
            }
        }

        if (stack.empty())
            return true;

        return false;
    }


    private static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {

            boolean ret = isValid("(]");

            String out = booleanToString(ret);

            System.out.print(out);

    }
}