/**
 * author: akhilpathivada
 * time: 29/04/24 16:08
 */
package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitIntoBaskets {

    private int totalFruit(int[] fruits) {
        int result = 0;
        int left = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < fruits.length; ++right) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.getOrDefault(fruits[left], 0) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                ++left;
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
