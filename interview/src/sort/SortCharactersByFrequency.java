/**
 * Date 04/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1) -> for 26 characters
 *
 */
package sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
        private String sortCharacters(String s) {
                final Map<Character, Integer> map = new HashMap<>();
                for (char c : s.toCharArray()) { // insert all character, frequency into map
                        map.put(c, map.getOrDefault(c, 0) + 1);
                }
                final PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
                maxHeap.addAll(map.entrySet()); // add all map elements into max heap
                final StringBuilder sb = new StringBuilder();
                while (!maxHeap.isEmpty()) { // iterate till heap becomes empty
                        Map.Entry<Character, Integer> e = maxHeap.poll();
                        sb.append(String.valueOf(e.getKey()).repeat(Math.max(0, e.getValue()))); // append character on repeat of it's frequency
                }
                return sb.toString();
        }
        public static void main(String[] args) {
                String s = "tree";
                System.out.printf("Sorted String = %s ", new SortCharactersByFrequency().sortCharacters(s));
        }
}
