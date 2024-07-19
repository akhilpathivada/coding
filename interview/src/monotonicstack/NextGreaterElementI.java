package monotonicstack;

import java.util.*;

/**
 * Date 14/04/24
 * Time 19:20
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/next-greater-element-i/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class NextGreaterElementI {

    private int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final Stack<Integer> stack = new Stack<>();
        final Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        final List<Integer> result = new ArrayList<>(nums1.length);
        Arrays.stream(nums1).forEach(num -> result.add(map.getOrDefault(num, -1)));
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(new NextGreaterElementI().nextGreaterElement(nums1, nums2)));
    }
}
