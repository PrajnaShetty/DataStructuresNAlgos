package leetcode.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    private static  List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
        backTrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private static void backTrack(List<List<Integer>> res, List<Integer> tempRes, int[] candidates, int remain,
                           int start) {
        if (remain < 0) return;
        else if (remain == 0) res.add(new ArrayList<>(tempRes));
        else {
            for (int i = start; i < candidates.length; i++) {
                tempRes.add(candidates[i]);
                backTrack(res, tempRes, candidates, remain - candidates[i], i);
                tempRes.remove(tempRes.size() - 1);
            }
        }
    }

    public static int[] stringToIntegerArray(String input) {
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

    private static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    private static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    private static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] candidates = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            List<List<Integer>> ret = combinationSum(candidates, target);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}