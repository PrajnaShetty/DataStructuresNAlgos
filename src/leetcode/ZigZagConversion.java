package leetcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ZigZagConversion {
    private static String convert(String s, int numRows) {
        int i = 0;
        String temp ;
        s = s.replaceAll("\"", "");
        s = s.replaceAll("\\\\", "");

        List<String> lists = new ArrayList<>();
        for (int j = 0; j < numRows; j++) {
            lists.add("");
        }

        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); j++) {
                temp = lists.get(j);
                temp = temp.concat(Character.toString(s.charAt(i)));
                lists.set(j, temp);
                i++;
            }

            for(int j = numRows - 2; j > 0 && i < s.length(); j--) {
                temp = lists.get(j);
                temp = temp.concat(Character.toString(s.charAt(i)));
                lists.set(j, temp);
                i++;
            }
        }

        String result = "";
        for(String str: lists) {

            result = result.concat(str);
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        String ret = convert("\"PAYPALISHIRING\"", 3);

        String out = (ret);

        System.out.print(out);
    }
}
