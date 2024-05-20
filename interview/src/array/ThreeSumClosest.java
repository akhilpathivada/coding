/**
 * author: akhilpathivada
 * time: 20/05/24 10:29
 */
package array;

import java.util.Arrays;

public class ThreeSumClosest {

    private int threeSumClosest(int[] nums, int target) {
        final int n = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int closest = 0;
        // Now fix the first element one by one and find the other two elements
        for (int i = 0; i < n - 2; ++i) {
            int low = i + 1;
            int high = n - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    ++low;
                } else {
                    --high;
                }
                int diff = Math.abs(sum - target);
                if (diff < min) {
                    min = diff;
                    closest = sum;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 1, 1};
        int target = 2;
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
    }
}
