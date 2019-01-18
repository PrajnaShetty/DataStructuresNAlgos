package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by prajnashetty on 12/27/18.
 */
public class FirstUniqueCharacterInString {

    private static int firstUniqChar(String s) {
        Map<Character, List<Integer>> charIndices = new HashMap<>();

        for (int i = 0; i < s.length() - 1; i++) {
            if (!charIndices.containsKey(s.charAt(i))) {
                charIndices.put(s.charAt(i), new ArrayList<Integer>());
            }
            charIndices.get(s.charAt(i)).add(i);
        }

        int lowIndex = Integer.MAX_VALUE;
        for(Character key: charIndices.keySet()) {
            List<Integer> list = charIndices.get(key);
            if (list.size() == 1)
                if (list.get(0) < lowIndex) {
                    lowIndex = list.get(0);
                }
        }

        return (lowIndex == Integer.MAX_VALUE) ? -1 : lowIndex;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("z"));
    }

}
