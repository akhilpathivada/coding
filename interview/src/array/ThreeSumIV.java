/**
 * https://leetcode.com/problems/3sum/
 * <p>
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 */
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSumIV {

    private static List<List<Integer>> printTriplets(int[] nums, int sum) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // Now fix the first element one by one and find the other two elements
        for (int i = 0; i < n - 2; ++i) {
            /** To find the other two elements, start two index variables
             from two corners of the array and move them toward each other */
            int low = i + 1; // index of the first element in the remaining elements
            int high = n - 1; // index of the last element
            while (low < high) {
                // triplet found
                if (nums[i] + nums[low] + nums[high] == sum) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    ++low;
                    --high;
                } else if (nums[i] + nums[low] + nums[high] < sum) {
                    ++low;
                } else {
                    --high;
                }
            }
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        int sum = 0;
        System.out.println(printTriplets(nums, sum));
    }
}
