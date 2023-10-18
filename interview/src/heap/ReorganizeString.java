/**
 * https://leetcode.com/problems/reorganize-string/description/
 *
 * Time Complexity: O(N * log(K)) -> where k is no. of distinct chars
 * Space Complexity: O(K)
 * */
package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public String reorganizeString(String s) {
        // base case
        if (s == null || s.isEmpty()) {
            return "";
        }
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());
        StringBuilder output = new StringBuilder();
        while (maxHeap.size() > 1) {
            char c1 = maxHeap.poll();
            char c2 = maxHeap.poll();
            output.append(c1).append(c2);
            frequencyMap.put(c1, frequencyMap.get(c1) - 1);
            frequencyMap.put(c2, frequencyMap.get(c2) - 1);
            if (frequencyMap.get(c1) > 0) {
                maxHeap.offer(c1);
            }
            if (frequencyMap.get(c2) > 0) {
                maxHeap.offer(c2);
            }
        }
        if (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            if (frequencyMap.get(c) > 1) {
                return "";
            }
            output.append(c);
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new ReorganizeString().reorganizeString(s));
    }
}
