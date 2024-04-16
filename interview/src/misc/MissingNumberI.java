package misc;

/**
 * Date 16/04/24
 * Time 16:22
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumberI {

    private int missingNumber(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            result ^= i;
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(new MissingNumberI().missingNumber(nums));
    }
}
