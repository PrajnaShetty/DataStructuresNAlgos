package stringmatching;

/**
 * Created by prajnashetty on 3/8/19.
 *
 * Average Complexity = O(n + m)
 * Worst case complexity - O(nm)
 *
 * Hash function used is Rabin fingerprint
 * Rehashing function should have complexity of O(1).
 *
 *
 *
 * Application :-
 * 1. Detecting plagiarism
 */
public class RabinKarpSearch{

    private int prime;

    RabinKarpSearch(int prime) {
        this.prime = prime;
    }

    private int patternSearch(String t, String p) {
        char[] text = t.toCharArray();
        char[] pattern = p.toCharArray();
        int n = text.length;
        int m = pattern.length;

        long patternHash = createHash(pattern, m);
        long textHash = createHash(text, m );


        for (int i = 1; i <= (n-m + 1); i++) {
            if (patternHash == textHash && checkEqual(text, i - 1, i + m - 2, pattern, 0, m - 1)) {
                return i - 1;
            }
            if (i < (n - m + 1 )) {
                textHash = recalculateHash(text, i - 1, i + m - 1, textHash, m);
            }
        }

        return -1;

    }

    private long recalculateHash(char[] text, int oldStartIndex, int newEndIndex, long prevHash, int len) {

        long newHash = prevHash - text[oldStartIndex];
        newHash /= prime;
        newHash += text[newEndIndex] * Math.pow(prime, len - 1);
        return newHash;
    }

    private boolean checkEqual(char[] text, int start1, int end1, char[] pattern, int start2, int end2) {
        if (end1 - start1 != end2 - start2)
            return false;

        while(start1 <= end1 && start2 <= end2) {
            if (text[start1] != pattern[start2]) {
                return false;
            }
            start1++; start2++;
        }

        return true;
    }

    private long createHash(char[] str, int len) {
        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash += str[i] * Math.pow(prime, i);
        }
        return hash;
    }

    public static void main(String[] args) {
        RabinKarpSearch rks = new RabinKarpSearch(101);
        System.out.println(rks.patternSearch("countnotthecostofgiving", "costof"));
        System.out.println(rks.patternSearch("countnotthecostofgiving", "ofcost"));
        System.out.println(rks.patternSearch("countnotthecostofgiving", "giving"));
        System.out.println(rks.patternSearch("countnotthecostofgiving", "count"));
        System.out.println(rks.patternSearch("countnotthecostofgiving", "notthe"));
    }
}
