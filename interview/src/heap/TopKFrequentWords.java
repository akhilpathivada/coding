/**
 * Date 09/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/top-k-frequent-words/description/
 *
 * Time Complexity: O(n * logk)
 * Space Complexity: O(n)
 */
package heap;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent_2(String[] words, int k) {
        // frequency map: stores (word, frequency)
        final Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }
        // use bucket sort
        // store into bucket as <frequency, element(s)> format
        final List<String>[] bucket = new List[words.length + 1];
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            String word = entry.getKey();
            int frequency = entry.getValue();
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(word);
            Collections.sort(bucket[frequency]);
        }
        final List<String> result = new ArrayList<>();
        int remainingWordsToBeAddedToResult = k;
        for (int i = bucket.length - 1; i >= 0 && remainingWordsToBeAddedToResult > 0; --i) {
            if (bucket[i] != null) {
                int size = bucket[i].size();
                if (size <= remainingWordsToBeAddedToResult) {
                    remainingWordsToBeAddedToResult -= size;
                    result.addAll(bucket[i]);
                } else {
                    for (int j = 0; j < remainingWordsToBeAddedToResult; ++j) {
                        result.add(bucket[i].get(j));
                    }
                    remainingWordsToBeAddedToResult = 0;
                }
            }
        }
        return result;
    }

    public List<String> topKFrequent(String[] words, int k) {
        // frequency map: stores (word, frequency)
        final Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }
        final PriorityQueue<String> minHeap = new PriorityQueue<String>((w1, w2) -> {
            int c1 = wordFrequencyMap.get(w1);
            int c2 = wordFrequencyMap.get(w2);
            return (c1 == c2) ? w2.compareTo(w1) : c1 - c2;
        });
        for (String word : wordFrequencyMap.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        final LinkedList<String> result = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            result.addFirst(minHeap.poll());
        }
        return result;
    }

    public static void main(String[] args) {
//        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String[] words = {"a", "aa", "aaa"};
        int k = 3;
        System.out.println(new TopKFrequentWords().topKFrequent(words, k));
    }
}
