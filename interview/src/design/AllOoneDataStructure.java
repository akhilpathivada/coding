/**
 * author: akhilpathivada
 * time: 05/06/24 18:10
 *
 * https://leetcode.com/problems/all-oone-data-structure/description/
 *
 */
package design;

import java.util.*;

public class AllOoneDataStructure {

    private final Map<String, Integer> stringToFreqMap;

    private final TreeMap<Integer, Set<String>> freqToStringsMap;

    public AllOoneDataStructure() {
        this.stringToFreqMap = new HashMap<>();
        this.freqToStringsMap = new TreeMap<>();
    }

    public void inc(String key) {
        int oldFreq = stringToFreqMap.getOrDefault(key, 0);
        update(key, oldFreq, oldFreq + 1);
    }

    public void dec(String key) {
        if (!stringToFreqMap.containsKey(key)) {
            return;
        }
        int oldFreq = stringToFreqMap.getOrDefault(key, 0);
        update(key, oldFreq, oldFreq - 1);
    }

    public String getMaxKey() {
        return freqToStringsMap.isEmpty() ? "" : freqToStringsMap.lastEntry().getValue().iterator().next();
    }

    public String getMinKey() {
        return freqToStringsMap.isEmpty() ? "" : freqToStringsMap.firstEntry().getValue().iterator().next();
    }

    private void update(String key, int oldFreq, int newFreq) {
        stringToFreqMap.put(key, newFreq);
        final Set<String> set = freqToStringsMap.getOrDefault(oldFreq, null);
        if (set != null) {
            set.remove(key);
            if (set.isEmpty()) {
                freqToStringsMap.remove(oldFreq);
            }
        }
        if (newFreq > 0) {
            freqToStringsMap.computeIfAbsent(newFreq, s -> new HashSet<>()).add(key);
        }
    }

    public static void main(String[] args) {
        AllOoneDataStructure allOne = new AllOoneDataStructure();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        System.out.println(allOne.getMinKey()); // return "a"
        allOne.dec("a");
        System.out.println(allOne.getMaxKey()); // return "c"
        System.out.println(allOne.getMinKey()); // return "c"
    }
}
