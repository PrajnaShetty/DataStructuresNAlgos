package leetcode;

/**
 * Created by prajnashetty on 12/31/18.
 */
class ValidPalindrome2 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    public static boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;

        if (s.isEmpty())
            return true;

        while (low <= high) {
            if (s.charAt(low) == ' ') {
                low++;
            }

            if (s.charAt(high) == ' ') {
                high--;
            }

            char lowChar = s.charAt(low);
            char highChar = s.charAt(high);

            if (!String.valueOf(lowChar).equalsIgnoreCase(String.valueOf(highChar)))
                return false;
        }

        return true;

    }
}
