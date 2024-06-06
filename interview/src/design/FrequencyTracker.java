/**
 * author: akhilpathivada
 * time: 06/06/24 08:28
 *
 * https://leetcode.com/problems/frequency-tracker/description/
 *
 */
package design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrequencyTracker {

    private final Map<Integer, Integer> numberToFrequencyMap;

    private final Map<Integer, Set<Integer>> frequencyToNumbersMap;

    public FrequencyTracker() {
        this.numberToFrequencyMap = new HashMap<>();
        this.frequencyToNumbersMap = new HashMap<>();
    }

    public void add(int number) {
        int oldFrequency = numberToFrequencyMap.getOrDefault(number, 0);
        update(number, oldFrequency, oldFrequency + 1);
    }

    public void deleteOne(int number) {
        int oldFrequency = numberToFrequencyMap.getOrDefault(number, 0);
        if (oldFrequency == 0) {
            return;
        }
        update(number, oldFrequency, oldFrequency - 1);
    }

    public boolean hasFrequency(int frequency) {
        return frequencyToNumbersMap.containsKey(frequency);
    }

    private void update(int number, int oldFrequency, int newFrequency) {
        numberToFrequencyMap.put(number, newFrequency);
        Set<Integer> set = frequencyToNumbersMap.getOrDefault(oldFrequency, null);
        if (set != null) {
            set.remove(number);
            if (set.isEmpty()) {
                frequencyToNumbersMap.remove(oldFrequency);
            }
        }
        if (newFrequency > 0) {
            frequencyToNumbersMap.computeIfAbsent(newFrequency, s -> new HashSet<>()).add(number);
        }
    }

    public static void main(String[] args) {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        frequencyTracker.deleteOne(2);
        frequencyTracker.deleteOne(1);
        frequencyTracker.add(1);
        System.out.println(frequencyTracker.hasFrequency(1)); // Returns true
        System.out.println(frequencyTracker.hasFrequency(1)); // Returns true
        System.out.println(frequencyTracker.hasFrequency(1)); // Returns true
    }
}
