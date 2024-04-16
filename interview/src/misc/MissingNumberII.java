package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date 16/04/24
 * Time 16:25
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 *
 */
public class MissingNumberII {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            nums[Math.abs(nums[i]) - 1] = -1 * Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new MissingNumberII().findDisappearedNumbers(nums));
    }
}
