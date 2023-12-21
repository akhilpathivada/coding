/**
 * https://leetcode.com/problems/longest-duplicate-substring/description/
 * https://www.codingninjas.com/studio/problems/longest-duplicate-substring_1229794
 *
 * (Rolling Hash)
 *
 * Time Complexity: O(log(N) * O(N))
 * Space Complexity: O(N)
 * */
package patternmatch.rollinghash;

import java.util.HashSet;
import java.util.Set;

public class LongestDuplicateSubstring {

    private final int prime = 101;

    private long nextHash(char[] str, int oldIndex, int newIndex, long oldHash, int patternLength) {  // O(1)
        long newHash = oldHash - str[oldIndex];
        newHash = newHash / prime;
        newHash += (long) (str[newIndex] * Math.pow(prime, patternLength - 1));
        return newHash;
    }

    private long createHash(char[] str, int end) { // O(1)
        long hash = 0;
        for (int i = 0; i < end; ++i) {
            hash += (long) (str[i] * Math.pow(prime, i));
        }
        return hash;
    }

    private String getDuplicateSubstring(int size, String s) {
        long hash = createHash(s.substring(0, size).toCharArray(), size);
        Set<Long> set = new HashSet<>();
        set.add(hash);
        // start iteration from next substring of the size
        for (int i = size; i < s.length(); ++i) {  // O(N)
            hash = nextHash(s.toCharArray(), i - size, i, hash, size);
            if (!set.add(hash)) { // found
                return s.substring(i - size + 1, i + 1);
            }
        }
        return null;
    }

    private String longestDupSubstring(String s) {
        String result = "";
        int left = 0;
        int right = s.length() - 1;
        // apply binary search to get the size of a substring each time
        while (left <= right) { // O(log(N))
            int mid = left + (right - left) / 2;
            String duplicateSubstring = getDuplicateSubstring(mid, s);
            if (null != duplicateSubstring) {
                result = duplicateSubstring;
                left = mid + 1; // search for max. dup substring
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "banana";
        System.out.println(new LongestDuplicateSubstring().longestDupSubstring(s));
    }
}
