/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * https://www.codingninjas.com/studio/problems/stringmatch-rabincarp_1115738
 *
 * (Rolling Hash Technique)
 *
 * In the Rabin Karp algorithm, we have calculated the hash value of the pattern in O(Np) time and traversed the given
 * string for calculating the hash value and comparing the corresponding hash value with that of the pattern in O(Ns) time.
 * So, the time complexity is O(Ns + Np), where ‘Ns’ and ‘Np’ are the lengths of the given string and pattern respectively.
 *
 * Space complexity : O(1)
 *
 * */
package patternmatch;

public class RabinKarpAlgorithm {

    private final int prime = 101;

    private boolean areStringsEqual(char[] str1, int start1, int end1, char[] str2, int start2, int end2) {
        // both strings are of unequal sizes
        if (end1 - start1 != end2 - start2) {
            return false;
        }
        while (start1 < end1 && start2 < end2) {
            if (str1[start1] != str2[start2]) {
                return false;
            }
            ++start1;
            ++start2;
        }
        return true;
    }

    private long recalculateHash(char[] str, int oldIndex, int newIndex, long oldHash, int patternLength) {
        long newHash = oldHash - str[oldIndex];
        newHash = newHash / prime;
        newHash += (long) (str[newIndex] * Math.pow(prime, patternLength - 1));
        return newHash;
    }

    private long createHash(char[] str, int end) {
        long hash = 0;
        for (int i = 0; i < end; ++i) {
            hash += (long) (str[i] * Math.pow(prime, i));
        }
        return hash;
    }

    private int patternSearch(char[] text, char[] pattern) {
        int m = pattern.length;
        int n = text.length;
        // hash value for pattern
        long patternHash = createHash(pattern, m);
        long textHash = createHash(text, m);
        // slide the pattern over text one by one
        for (int i = 0; i <= n - m; ++i) {
            // check the hash values of current window of text and pattern.
            // if the hash values match then only check for characters one by one
            if (patternHash == textHash && areStringsEqual(text, i, i + m, pattern, 0, m)) {
                return i;
            }
            // calculate hash value for next window of text:
            // remove leading digit, add trailing digit
            if (i < n - m) {
                textHash = recalculateHash(text, i, i + m, textHash, m);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RabinKarpAlgorithm rabinKarpAlgorithm = new RabinKarpAlgorithm();
        System.out.println(rabinKarpAlgorithm.patternSearch("TusharRoy".toCharArray(), "sharRoy".toCharArray()));
        System.out.println(rabinKarpAlgorithm.patternSearch("TusharRoy".toCharArray(), "Roy".toCharArray()));
        System.out.println(rabinKarpAlgorithm.patternSearch("TusharRoy".toCharArray(), "shas".toCharArray()));
        System.out.println(rabinKarpAlgorithm.patternSearch("TusharRoy".toCharArray(), "usha".toCharArray()));
        System.out.println(rabinKarpAlgorithm.patternSearch("TusharRoy".toCharArray(), "Tus".toCharArray()));
    }
}
