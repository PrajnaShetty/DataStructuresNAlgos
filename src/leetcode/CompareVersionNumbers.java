package leetcode;

/**
 * Created by prajnashetty on 4/6/19.
 */
public class CompareVersionNumbers {

    public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");

        int i = 0;
        while (i < s1.length && i < s2.length) {
            int num1 = Integer.parseInt(s1[i]);
            int num2 = Integer.parseInt(s2[i]);

            if (num1 > num2)
                return 1;
            else if (num1 < num2)
                return -1;
            else
                i++;

        }

        if (i < s1.length)
            return 1;

        if (i < s2.length)
            return -1;

        return 0;

    }


    public static void main(String[] args) {
        System.out.println(CompareVersionNumbers.compareVersion("0.1", "1.1"));
    }

}
