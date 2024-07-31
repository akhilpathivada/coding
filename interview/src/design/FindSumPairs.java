/**
 * author: akhilpathivada
 * time: 06/06/24 16:27
 *
 * https://leetcode.com/problems/finding-pairs-with-a-certain-sum/
 *
 */
package design;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class FindSumPairs {

    private final int[] nums1;

    private final int[] nums2;

    private final Map<Integer, Integer> numberToCountMap;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.numberToCountMap = new HashMap<>();
        Arrays.stream(nums2).forEach(num ->
                numberToCountMap.put(num, numberToCountMap.getOrDefault(num, 0) + 1));
    }

    public void add(int index, int val) {
        numberToCountMap.put(nums2[index], numberToCountMap.get(nums2[index]) - 1);
        nums2[index] += val;
        numberToCountMap.put(nums2[index], numberToCountMap.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        return Arrays.stream(nums1).reduce(0, (pairs, num) ->
                pairs + numberToCountMap.getOrDefault(tot - num, 0));
    }

    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        findSumPairs.count(7);  // return 8; pairs (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) make 2 + 5 and pairs (5,1), (5,5) make 3 + 4
        findSumPairs.add(3, 2); // now nums2 = [1,4,5,4,5,4]
        System.out.println(findSumPairs.count(8));  // return 2; pairs (5,2), (5,4) make 3 + 5
        System.out.println(findSumPairs.count(4));  // return 1; pair (5,0) makes 3 + 1
        findSumPairs.add(0, 1); // now nums2 = [2,4,5,4,5,4]
        findSumPairs.add(1, 1); // now nums2 = [2,5,5,4,5,4]
        System.out.println(findSumPairs.count(7));  // return 11; pairs (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) make 2 + 5 and pairs (5,3), (5,5) make 3 + 4
    }
}