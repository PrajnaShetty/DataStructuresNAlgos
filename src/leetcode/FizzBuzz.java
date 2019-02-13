package leetcode;

/**
 * Created by prajnashetty on 1/31/19.
 */
public class FizzBuzz {

    public static void main(String[] args) {
        String output;
        for (int i = 1; i <= 100; i++) {
            output = "";
            if (i % 3 == 0) output += "Fizz";
            if (i % 5 == 0) output += "Buzz";
            //if (i % 7 == 0) output += "Fuzz";

            if (output.equals("")) output = i + "";
            System.out.println(output);
        }
    }
}
