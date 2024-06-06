/**
 * author: akhilpathivada
 * time: 06/06/24 09:17
 *
 * https://leetcode.com/problems/design-a-number-container-system/
 *
 */
package design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class NumberContainers {

    private final Map<Integer, Integer> indexToNumberMap;

    private final Map<Integer, TreeSet<Integer>> numberToIndexesMap;

    public NumberContainers() {
        this.indexToNumberMap = new HashMap<>();
        this.numberToIndexesMap = new HashMap<>();
    }

    public void change(int index, int number) {
        update(index, indexToNumberMap.getOrDefault(index, number), number);
    }

    public int find(int number) {
        return numberToIndexesMap.containsKey(number)
                ? numberToIndexesMap.get(number).first()
                : -1;
    }

    private void update(int index, int oldNumber, int newNumber) {
        indexToNumberMap.put(index, newNumber);
        TreeSet<Integer> indexes = numberToIndexesMap.getOrDefault(oldNumber, null);
        if (oldNumber != newNumber && indexes != null) {
            indexes.remove(index);
            if (indexes.isEmpty()) {
                numberToIndexesMap.remove(oldNumber);
            }
        }
        numberToIndexesMap.computeIfAbsent(newNumber, s -> new TreeSet<>()).add(index);
    }

    public static void main(String[] args) {
        NumberContainers nc = new NumberContainers();
        nc.find(10); // There is no index that is filled with number 10. Therefore, we return -1.
        nc.change(2, 10); // Your container at index 2 will be filled with number 10.
        nc.change(1, 10); // Your container at index 1 will be filled with number 10.
        nc.change(3, 10); // Your container at index 3 will be filled with number 10.
        nc.change(5, 10); // Your container at index 5 will be filled with number 10.
        System.out.println(nc.find(10)); // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
        nc.change(1, 20); // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20.
        System.out.println(nc.find(10)); // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.
    }
}
