/**
 * @author akhilpathivada
 * <p>
 * date : 02/04/24
 * time: 10:43
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(1)
 */
package dp.path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {

    private int minimumTotal_BottomUp(List<List<Integer>> triangle) {
        // bottom-up
        // starting from the last second row
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                int sum = triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                // set the path sum for the current cell
                triangle.get(i).set(j, sum);
            }
        }
        return triangle.get(0).get(0);
    }

    private int minimumTotal_TopDown(List<List<Integer>> triangle) {
        // top-down
        // starting from the second row
        for (int i = 1; i < triangle.size(); ++i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                int sum = 0;
                int currentElement = triangle.get(i).get(j);
                // for element at left most column
                if (j == 0) {
                    sum = currentElement + triangle.get(i - 1).get(j);
                } else if (j == triangle.get(i).size() - 1) { // for element at right most column
                    sum = currentElement + triangle.get(i - 1).get(triangle.get(i - 1).size() - 1);
                } else {
                    sum = currentElement + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                }
                // set the path sum for the current cell
                triangle.get(i).set(j, sum);
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3, 4)));
        triangle.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        triangle.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
        System.out.println(new Triangle().minimumTotal_BottomUp(triangle));
//        System.out.println(new Triangle().minimumTotal_TopDown(triangle));
    }
}
