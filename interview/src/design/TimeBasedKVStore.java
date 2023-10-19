/**
 * https://leetcode.com/problems/time-based-key-value-store/description/
 *
 * Time Complexity:
 *      for set() - O(1)
 *      for get() - O(log(N))
 * */
package design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TimeBasedKVStore {

    private static class TimeMap {

        private class Pair {
            int timestamp;
            String value;

            Pair(int timestamp, String value) {
                this.timestamp = timestamp;
                this.value = value;
            }
        }

        private Map<String, ArrayList<Pair>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>(Collections.singletonList(new Pair(timestamp, value))));
                return;
            }
            map.get(key).add(new Pair(timestamp, value));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }
            String result = "";
            ArrayList<Pair> arr = map.get(key);
            int low = 0, high = arr.size() - 1;
            // do binary search
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int timestampValue = arr.get(mid).timestamp;
                if (timestampValue == timestamp) {
                    return arr.get(mid).value;
                } else if (timestampValue < timestamp) {
                    result = arr.get(low).value;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println(timeMap.get("foo", 1));         // return "bar"
        System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        System.out.println(timeMap.get("foo", 4));         // return "bar2"
        System.out.println(timeMap.get("foo", 5));         // return "bar2"
    }
}
