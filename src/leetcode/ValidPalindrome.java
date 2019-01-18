package leetcode;

class ValidPalindrome {
    private static boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while(i != j) {
            if(!isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!isLetterOrDigit(s.charAt(j))) {
                j++;
            } else {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return true;
    }

    private static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }


    private static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) {

            boolean ret = isPalindrome("A man, a plan, a canal: Panama");

            String out = booleanToString(ret);

            System.out.print(out);

    }
}