package leetcode;

import java.util.*;

/**
 * Created by prajnashetty on 12/18/18.
 */
class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return null;

        Map<String, List> result = new HashMap<>();

        for (String s : strs) {
            char[] sCharArray = s.toCharArray();

            Arrays.sort(sCharArray);
            String key = String.valueOf(sCharArray);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
                result.get(key).add(s);
        }

        return new ArrayList(result.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(input);
        System.out.println(res);
    }
}