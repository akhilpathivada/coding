/**
 * https://leetcode.com/problems/count-of-range-sum/description/
 * */
package fenwicktree;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CountOfRangeSum {

    private void insert(int[] binaryIndexedTree, int index, int n) {
        while (index < n) {
            binaryIndexedTree[index]++;
            index = index + (index & -index);
        }
    }

    private int query(int[] binaryIndexedTree, int index) {
        int ans = 0;
        while (index > 0) {
            ans += binaryIndexedTree[index];
            index = index - (index & -index);
        }
        return ans;
    }

    private int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        // compute prefix sum for the entire array
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        // sort the prefix sums
        Arrays.sort(prefixSum);
        // store <prefixSum, index>
        TreeMap<Long, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(prefixSum[i], i + 1);
        }
        // binary indexed tree
        int[] binaryIndexedTree = new int[n + 1];
        int countOfSumsInRange = 0;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum >= lower && sum <= upper) {
                ++countOfSumsInRange;
            }
            int left = 0, right = 0;
            long lowerBound = sum - lower;
            long upperBound = sum - upper - 1;
            if (map.floorKey(lowerBound) != null) {
                int key = map.floorEntry(lowerBound).getValue();
                right = query(binaryIndexedTree, key);
            }
            if (map.floorKey(upperBound) != null) {
                int key = map.floorEntry(upperBound).getValue();
                left = query(binaryIndexedTree, key);
            }
            countOfSumsInRange += (right - left);
            insert(binaryIndexedTree, map.get(sum), n + 1);
        }
        return countOfSumsInRange;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 5, -1 };
        int lower = -2, upper = 2;
        System.out.println(new CountOfRangeSum().countRangeSum(nums, lower, upper));
    }
}
