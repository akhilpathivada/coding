package monotonicstack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Date 15/04/24
 * Time 00:12
 *
 * @author akhilpathivada
 */
public class Find132Pattern {

    private boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] prevGreater = new int[n];
        int[] prevMin = new int[n];
        Arrays.fill(prevGreater, -1);
        Arrays.fill(prevMin, Integer.MAX_VALUE);
        Stack<Integer> stack = new Stack<>();
        int minSoFar = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                prevGreater[i] = stack.peek();
            }
            minSoFar = Math.min(minSoFar, nums[i]);
            prevMin[i] = minSoFar;
            stack.push(i);
        }
        System.out.println(Arrays.toString(prevGreater));
        System.out.println(Arrays.toString(prevMin));
        for (int i = 0; i < n; ++i) {
            if (prevGreater[i] != -1 && prevMin[i] != nums[i]
                    && prevMin[prevGreater[i]] < nums[i]) {
                System.out.println("fro = " + i);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, 1};
        System.out.println(new Find132Pattern().find132pattern(nums));
    }
}
