/**
 * author: akhilpathivada
 * time: 17/05/24 09:09
 *
 * https://leetcode.com/problems/interval-list-intersections/description/
 *
 */
package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {

    private int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        final List<int[]> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            int first = firstList[i][0];
            int second = firstList[i][1];
            int third = secondList[j][0];
            int fourth = secondList[j][1];
            if (first <= fourth && second >= third) {
                result.add(new int[]{Math.max(first, third), Math.min(second, fourth)});
            }
            if (second < fourth) {
                ++i;
            } else {
                ++j;
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println(Arrays.deepToString(new IntervalListIntersections().intervalIntersection(firstList, secondList)));
    }
}
