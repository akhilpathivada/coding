/**
 * author: akhilpathivada
 * time: 02/06/24 07:23
 *
 * https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/
 *
 */
package patternmatch.rollinghash;

import java.util.HashMap;
import java.util.Map;

public class CountPrefixAndSuffixPairsI {

    private boolean areStringsEqual(String s1, String s2) {
        return s1.equals(s2);
    }

    private long createHash(String s) {
        long hash = 0;
        for (int i = 0; i < s.length(); ++i) {
            int prime = 101;
            hash += (long) (s.charAt(i) * Math.pow(prime, i));
        }
        return hash;
    }

    private int countPrefixSuffixPairs(String[] words) {
        final Map<String, Long> hashMap = new HashMap<>();
        int pairs = 0;
        for (int i = 0; i < words.length; ++i) {
            String pattern = words[i];
            int m = pattern.length();
            long patternHash = hashMap.getOrDefault(pattern, createHash(pattern));
            if (!hashMap.containsKey(pattern)) {
                hashMap.put(pattern, patternHash);
            }
            for (int j = i + 1; j < words.length; ++j) {
                String text = words[j];
                int n = text.length();
                if (n < m) {
                    continue;
                }
                String prefix = text.substring(0, m);
                long prefixHash = hashMap.getOrDefault(prefix, createHash(prefix));
                if (!hashMap.containsKey(prefix)) {
                    hashMap.put(prefix, prefixHash);
                }
                String suffix = text.substring(n - m, n);
                long suffixHash = hashMap.getOrDefault(suffix, createHash(suffix));
                if (!hashMap.containsKey(suffix)) {
                    hashMap.put(suffix, suffixHash);
                }
                if (prefixHash == patternHash
                        && suffixHash == patternHash
                        && areStringsEqual(prefix, pattern)
                        && areStringsEqual(suffix, pattern)) {
                    ++pairs;
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        String[] words = {"a", "aba", "ababa", "aa"};
        System.out.println(new CountPrefixAndSuffixPairsI().countPrefixSuffixPairs(words));
    }
}
