package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by prajnashetty on 12/28/18.
 */
public class GrayCode {

    public static void main(String[] args) {
        System.out.println("leetcode.GrayCode = " + grayCode(2));
    }

    private static List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < Math.pow(2,n); i++)
            result.add(i ^ i/2);
        return result;
    }

}
