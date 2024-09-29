/**
 * author: akhilpathivada
 * time: 29/09/24 13:28
 *
 * https://leetcode.com/problems/arithmetic-slices/description/?
 *
 */
package slidingwindow;

public class ArithmeticSlices {

    private int numberOfArithmeticSlices(int[] nums) {
        int current = 0;
        int result = 0;
        for (int i = 2; i < nums.length; ++i) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                ++current;
                result += current;
            } else {
                current = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(nums));
    }
}
