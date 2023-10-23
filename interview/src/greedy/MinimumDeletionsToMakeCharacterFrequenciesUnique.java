/**
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/description/
 *
 * Time Complexity: O(N * log(N))
 * Space Complexity: O(K) where K = 26
 * */

package greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    private int minDeletions(String s) {
        // Create a HashMap to count the frequency of each character.
        Map<Character, Integer> frequencyMap = new HashMap<>();
        // Iterate through the characters in the input string 's'.
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        // Create a max-heap (PriorityQueue) to store character frequencies in decreasing order.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // Populate the max-heap with character frequencies from the map
        maxHeap.addAll(frequencyMap.values());
        int count = 0;
        // Continue as long as there are at least two frequencies in the max-heap.
        while (maxHeap.size() >= 2) {
            int top = maxHeap.poll();
            // Check if the next character in the max-heap has the same frequency as 'top' (and it's not zero).
            if (maxHeap.peek() != null && maxHeap.peek() == top && top != 0) {
                // Increment the deletion count.
                ++count;
                // Decrease 'top' frequency by 1 and push it back into the max-heap.
                maxHeap.add(top - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aaabbbcc";
        System.out.println(new MinimumDeletionsToMakeCharacterFrequenciesUnique().minDeletions(s));
    }
}
