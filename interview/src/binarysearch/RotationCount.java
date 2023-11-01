/**
 * https://www.codingninjas.com/studio/problems/rotation_7449070
 *
 * Time Complexity : O(log(N))
 * Space Complexity : O(1)
 */
package binarysearch;

public class RotationCount {

    private int findKRotation(int[] nums) {
        // Write your code here.
        int n = nums.length;
        // base cases
        if (n == 0) {
            return 0;
        }
        int left = 0, right = n - 1;
        // find the pivot index : that is the place where rotation happened
        // elements before and after pivot point are sorted.
        // min will be the next one of pivot
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 7, 1, 2, 3 };
        System.out.println(new RotationCount().findKRotation(nums));
    }
}
