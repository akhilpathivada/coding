/**
 * author: akhilpathivada
 * time: 29/04/24 16:08
 *
 *
 */
package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    private int totalFruit(int[] fruits) {
        int result = 0;
        int left = 0;
        final Map<Integer, Integer> fruitTypeToCountMap = new HashMap<>();
        for (int right = 0; right < fruits.length; ++right) {
            fruitTypeToCountMap.put(fruits[right], fruitTypeToCountMap.getOrDefault(fruits[right], 0) + 1);
            while (fruitTypeToCountMap.size() > 2) {
                int fruitType = fruits[left++];
                fruitTypeToCountMap.put(fruitType, fruitTypeToCountMap.getOrDefault(fruitType, 0) - 1);
                if (fruitTypeToCountMap.get(fruitType) == 0) {
                    fruitTypeToCountMap.remove(fruitType);
                }
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(new FruitIntoBaskets().totalFruit(fruits));
    }
}
