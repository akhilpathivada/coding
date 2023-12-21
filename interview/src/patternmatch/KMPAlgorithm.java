/**
 *
 * https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
 *
 * Time Complexity: O(N + M) where N is the length of the text and M is the length of the pattern to be found.
 * Space Complexity: O(M)
 * */
package patternmatch;

public class KMPAlgorithm {

    // lps :: Longest Prefix Suffix
    // compute lps array to maintain size of suffix which is same as prefix, where
    // lps[i] -> size of suffix ending at 'i' which has a matching prefix
    private int[] computeLPS(char[] pattern, int m) {
        int[] lps = new int[m];
        int len = 0; // length of the previous longest prefix substring
        lps[0] = 0; // lps[0] is always 0
        // the loop calculates lps[i] for i = 1 to m - 1
        for (int i = 1; i < m; ) {
            // characters match : found a suffix (ending here at 'i')
            // which has same prefix with size of 'len + 1'
            if (pattern[i] == pattern[len]) {
                lps[i] = len + 1;
                ++len;
                ++i;
            } else {
                if (len != 0) { // 'len' should go back to the point where, the next highest string match
                    len = lps[len - 1];
                } else { // no matching prefix found, so mark lps[i] = 0
                    lps[i] = 0;
                    ++i;
                }
            }
        }
        return lps;
    }

    private boolean KMP(char[] text, char[] pattern) {
        int m = pattern.length;
        int n = text.length;
        int[] lps = computeLPS(pattern, m);
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (text[i] == pattern[j]) {
                ++i;
                ++j;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    ++i;
                }
            }
            if (j == m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        System.out.println(new KMPAlgorithm().KMP(text.toCharArray(), pattern.toCharArray()));
    }
}
