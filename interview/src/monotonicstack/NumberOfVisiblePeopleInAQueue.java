package monotonicstack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Date 18/04/24
 * Time 09:28
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/number-of-visible-people-in-a-queue/description/
 *
 *
 */
public class NumberOfVisiblePeopleInAQueue {

    private int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] countOfPersonsICanSee = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            // previous persons who are shorter than person-i can see person-i
            // so increment their seeing count by 1
            while (!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
                countOfPersonsICanSee[stack.pop()]++;
            }
            // previous taller person to person-i can also person-i
            if (!stack.isEmpty()) {
                countOfPersonsICanSee[stack.peek()]++;
            }
            stack.push(i);
        }
        return countOfPersonsICanSee;
    }

    public static void main(String[] args) {
        int[] heights = {10, 6, 8, 5, 11, 9};
        System.out.println(Arrays.toString(new NumberOfVisiblePeopleInAQueue().canSeePersonsCount(heights)));
    }
}
