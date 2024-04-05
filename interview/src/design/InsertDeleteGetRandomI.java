/**
 * @author akhilpathivada
 * <p>
 * date : 03/04/24
 * time: 09:13
 *
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 *
 */
package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomI {

    private static class RandomizedSet {

        private final List<Integer> list;

        private final Map<Integer, Integer> hashMap;

        private final Random random;

        public RandomizedSet() {
            list = new ArrayList<>();
            hashMap = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (!hashMap.containsKey(val)) {
                // store val in the list: by default added at the end
                list.add(val);
                // store (val, index) in the map:
                // where, index is the position of val in the list
                hashMap.put(val, list.size() - 1);
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if (hashMap.containsKey(val)) {
                int indexOfValInTheList = hashMap.get(val);
                int lastIndexOfTheList = list.size() - 1;
                int lastElementOfTheList = list.get(lastIndexOfTheList);
                // replace the 'val' with last element of the list
                list.set(indexOfValInTheList, lastElementOfTheList);
                // update the index of last element in the map
                hashMap.put(lastElementOfTheList, indexOfValInTheList);
                // remove the last element from list
                list.remove(lastIndexOfTheList);
                // remove the val from hash map
                hashMap.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet.insert(2)); // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
        System.out.println(randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomizedSet.insert(2)); // 2 was already in the set, so return false.
        System.out.println(randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.
    }
}
