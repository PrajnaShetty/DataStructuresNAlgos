package leetcode;

/**
 * Created by prajnashetty on 3/20/19.
 */
public class ReverseWordsInAString {

    public static void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);

        int i = 0, prev = 0;

        while(i < str.length) {
            if (str[i] == ' ') {
                reverse(str, prev, i - 1);
                prev = i + 1;
            }
            i++;
        }

    }

    private static void reverse(char[] str, int start, int end) {
        while (start <= end) {
            swap(str, start, end);
            start++;
            end--;
        }
    }

    private static void swap(char[] str, int start, int end) {
        char temp = str[start];
        str[start] = str[end];
        str[end] = temp;
    }

    public static void main(String[] args) {
        char[] str = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(str);
    }

}
