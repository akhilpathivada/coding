/**
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 *
 * Time Complexity: O(N - )
 * */
package patternmatch.rollinghash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RepeatedDNASequences {

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

    private long nextHash(char[] str, int oldIndex, int newIndex, long oldHash, int patternLength) {
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

    // Using Hashtable
    private List<String> _findRepeatedDnaSequences(String s) { // O(N) * O(N * log(N))
        int sizeOfRequiredSubstring = 10;
        Set<String> result = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - sizeOfRequiredSubstring; ++i) {
            String substring = s.substring(i, i + sizeOfRequiredSubstring);
            if (!set.add(substring)) {
                result.add(substring);
            }
        }
        return result.stream().collect(Collectors.toList());
    }

    // Using Rolling Hash
    private List<String> findRepeatedDnaSequences(String s) {
        int sizeOfRequiredSubstring = 10;
        // hash value for pattern
        long hash = createHash(s.toCharArray(), sizeOfRequiredSubstring);
        Set<Long> set = new HashSet<>();
        set.add(hash);
        List<String> result = new ArrayList<>();
//        for (int i = sizeOfRequiredSubstring; i <= s.length() - sizeOfRequiredSubstring; ++i) {
//            String substring = s.substring(i, i + sizeOfRequiredSubstring);
//            hash = nextHash(s.toCharArray(), i - sizeOfSubstring, i, hash, sizeOfSubstring);
//            if (!set.add(hash)) {
//                result.add(substring);
//            }
//        }
        return result;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(new RepeatedDNASequences()._findRepeatedDnaSequences(s));
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences(s));
    }
}
