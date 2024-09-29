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

    private final Map<String, Integer> stringToFrequencyMap;

    private final TreeMap<Integer, Set<String>> frequencyToStringsMap;

    public AllOoneDataStructure() {
        this.stringToFrequencyMap = new HashMap<>();
        this.frequencyToStringsMap = new TreeMap<>();
    }

    public void inc(String key) {
        int oldFrequency = stringToFrequencyMap.getOrDefault(key, 0);
        update(key, oldFrequency, oldFrequency + 1);
    }

    public void dec(String key) {
        if (!stringToFrequencyMap.containsKey(key)) {
            return;
        }
        int oldFrequency = stringToFrequencyMap.getOrDefault(key, 0);
        update(key, oldFrequency, oldFrequency - 1);
    }

    public String getMaxKey() {
        return Optional.ofNullable(frequencyToStringsMap.lastEntry())
                .map(entry -> entry.getValue().iterator().next())
                .orElse("");
    }

    public String getMinKey() {
        return Optional.ofNullable(frequencyToStringsMap.firstEntry())
                .map(entry -> entry.getValue().iterator().next())
                .orElse("");
    }

    private void update(String key, int oldFrequency, int newFrequency) {
        stringToFrequencyMap.put(key, newFrequency);
        Optional.ofNullable(frequencyToStringsMap.get(oldFrequency))
                .ifPresent(set -> {
                    set.remove(key);
                    if (set.isEmpty()) {
                        frequencyToStringsMap.remove(oldFrequency);
                    }
                });
        if (newFrequency > 0) {
            frequencyToStringsMap.computeIfAbsent(newFrequency, s -> new HashSet<>()).add(key);
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
