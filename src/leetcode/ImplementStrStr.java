package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        int i = 0, j = 0, first = 0;
        while(i < haystack.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                first = i;
                while(j < needle.length() && i < haystack.length()) {
                    if(haystack.charAt(i) == needle.charAt(j)) {
                        if (j == needle.length() - 1 ) {
                            return first;
                        }
                        i++;
                        j++;

                    } else
                    {
                        j = 0;
                        break;
                    }
                }
            }
            i++;
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {


        int ret = strStr("mississippi", "issip");

        String out = String.valueOf(ret);

        System.out.print(out);

    }
}