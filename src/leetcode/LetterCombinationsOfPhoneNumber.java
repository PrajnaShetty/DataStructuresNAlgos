package leetcode;

import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

/**
 * Created by prajnashetty on 4/7/19.
 */
public class LetterCombinationsOfPhoneNumber {

    private static List<String> letterCOmbinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.isEmpty())
            return result;

        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz"};

        result.add(0, "");
        for (int i = 0 ; i < digits.length(); i++) {
            int size = result.size();
            int x = Character.getNumericValue(digits.charAt(i));

            for (int k = 0; k < size; k++) {
                String t = result.remove(0);
                for (char s : mapping[x].toCharArray()) {
                    result.add(t + s);
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {

        System.out.println(LetterCombinationsOfPhoneNumber.letterCOmbinations("456"));
    }
}
