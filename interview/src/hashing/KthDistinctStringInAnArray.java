/**
 * author: akhilpathivada
 * time: 05/08/24 08:31
 *
 * https://leetcode.com/problems/kth-distinct-string-in-an-array/description/
 *
 */
package hashing;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class KthDistinctStringInAnArray {

    private String kthDistinct(String[] arr, int k) {
        final Map<String, Boolean> map = new LinkedHashMap<>();
        Arrays.stream(arr).forEach(s -> map.put(s, map.containsKey(s)));
        for (String key : map.keySet()) {
            if (!map.get(key) && --k == 0) {
                return key;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] arr = {"d", "b", "c", "b", "c", "a"};
        int k = 2;
        System.out.println(new KthDistinctStringInAnArray().kthDistinct(arr, k));
    }
}
