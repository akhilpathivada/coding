package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 16/04/24
 * Time 16:38
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 *
 */
public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                result.add(Math.abs(nums[i]));
                continue;
            }
            nums[Math.abs(nums[i]) - 1] = -1 * nums[Math.abs(nums[i]) - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new FindAllDuplicatesInAnArray().findDuplicates(nums));
    }
}
