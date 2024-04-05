/**
 * @author akhilpathivada
 * <p>
 * date : 03/04/24
 * time: 10:12
 *
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/
 */
package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandomII {

    private static class RandomizedCollection {

        private final List<Integer> valueList;

        private final Map<Integer, Set<Integer>> valueToIndexesMap;

        private final Random random;

        public RandomizedCollection() {
            valueList = new ArrayList<>();
            valueToIndexesMap = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            boolean isPresent = valueToIndexesMap.containsKey(val);
            if (!isPresent) {
                // store (val, set<index>) in the map
                // where, index is the position of val in the list
                valueToIndexesMap.put(val, new LinkedHashSet<>());
            }
            // since because 'val' always added at the end of list
            valueToIndexesMap.get(val).add(valueList.size());
            // store val in the list (by default added at the end)
            valueList.add(val);
            return !isPresent;
        }

        public boolean remove(int val) {
            if (!valueToIndexesMap.containsKey(val)) {
                return false;
            }
            // removing the first occurrence of 'val'
            int locationOfValToRemove = valueToIndexesMap.get(val).iterator().next();
            valueToIndexesMap.get(val).remove(locationOfValToRemove);
            int lastIndexOfValueList = valueList.size() - 1;
            // if removed index it not the last one of the valueList
            if (locationOfValToRemove != lastIndexOfValueList) {
                int lastElement = valueList.get(lastIndexOfValueList);
                // updated the value list
                valueList.set(locationOfValToRemove, lastElement);
                // update the index set of lastElement
                valueToIndexesMap.get(lastElement).remove(lastIndexOfValueList);
                valueToIndexesMap.get(lastElement).add(locationOfValToRemove);
            }
            // if 'val' no more exists in the list
            if (valueToIndexesMap.get(val).isEmpty()) {
                valueToIndexesMap.remove(val);
            }
            valueList.remove(lastIndexOfValueList);
            return true;
        }

        public int getRandom() {
            return valueList.get(random.nextInt(valueList.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        System.out.println(randomizedCollection.insert(1));   // return true since the collection does not contain 1.
        // Inserts 1 into the collection.
        System.out.println(randomizedCollection.insert(1));   // return false since the collection contains 1.
        // Inserts another 1 into the collection. Collection now contains [1,1].
        System.out.println(randomizedCollection.insert(2));   // return true since the collection does not contain 2.
        // Inserts 2 into the collection. Collection now contains [1,1,2].
        System.out.println(randomizedCollection.getRandom()); // getRandom should:
        // - return 1 with probability 2/3, or
        // - return 2 with probability 1/3.
        System.out.println(randomizedCollection.remove(1));   // return true since the collection contains 1.
        // Removes 1 from the collection. Collection now contains [1,2].
        System.out.println(randomizedCollection.getRandom()); // getRandom should return 1 or 2, both equally likely.
    }
}
