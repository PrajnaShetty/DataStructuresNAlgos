package leetcode;

import java.util.ArrayList;
import java.util.List;

class MinWindowSubstring {

    private static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        List<String> substrings = new ArrayList<>();
        int tlen = 0;
        int i = 0;
        while (i < s.length()) {
            for (int j = i; j < s.length(); j++) {
                if (t.contains(Character.toString(s.charAt(j)))) {
                    tlen++;
                    if(tlen == t.length()) {
                        substrings.add(s.substring(i, j+1));
                        break;
                    }
                }
            }
            i++;
            tlen = 0;
        }

        if (substrings.size() == 0) {
            return "";
        }

        int min = substrings.get(0).length();
        String shortest = substrings.get(0);
        for(String sub: substrings) {
            if (sub.length() < min) {
                min = sub.length() ;
                shortest = sub;
            }
        }

        return shortest;

    }


    public static void main(String[] args){


        String ret = minWindow("bba", "ab");

        String out = (ret);

        System.out.print(out);

    }
}