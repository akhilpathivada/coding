/**
 * author: akhilpathivada
 * time: 10/06/24 09:58
 *
 * https://leetcode.com/problems/height-checker/
 *
 */
package greedy;

import java.util.Arrays;

public class HeightChecker {

    private int heightChecker(int[] heights) {
        final int[] expected = heights.clone();
        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < heights.length; ++i) {
            count += heights[i] != expected[i] ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
        System.out.println(new HeightChecker().heightChecker(heights));
    }
}
