/**
 * author: akhilpathivada
 * time: 02/06/24 10:15
 *
 * https://leetcode.com/problems/count-prefix-and-suffix-pairs-ii/
 *
 */
package patternmatch.rollinghash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountPrefixAndSuffixPairsII {

    private final int prime = 101;

    private Set<Long> hashSet;

    private Map<Long, Long> hashToPrefixCountMap;

    private boolean areStringsEqual(String s1, String s2) {
        return s1.equals(s2);
    }

    private long calculateHash(String s) {
        long hash = 0;
        for (int i = 0; i < s.length(); ++i) {
            hash += (long) (s.charAt(i) * Math.pow(prime, i));
        }
        return hash;
    }

    private long getMatchingPrefixCount(String s) {
        long hash = 0;
        long prefixCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            hash += (long) (s.charAt(i) * Math.pow(prime, i));
            if (hashSet.contains(hash)
                    && areStringsEqual(s.substring(0, i + 1),
                    s.substring(s.length() - 1 - i))) {
                prefixCount += hashToPrefixCountMap.get(hash);
            }
        }
        return prefixCount;
    }

    private long countPrefixSuffixPairs(String[] words) {
        hashSet = new HashSet<>();
        hashToPrefixCountMap = new HashMap<>();
        long pairs = 0;
        for (String word : words) {
            long hash = calculateHash(word);
            pairs += getMatchingPrefixCount(word);
            hashSet.add(hash);
            hashToPrefixCountMap.put(hash, hashToPrefixCountMap.getOrDefault(hashToPrefixCountMap.get(hash), 0L) + 1);
        }
        return pairs;
    }

    public static void main(String[] args) {
        String[] words = {"a", "aba", "ababa", "aa"};
        System.out.println(new CountPrefixAndSuffixPairsII().countPrefixSuffixPairs(words));
    }
}
