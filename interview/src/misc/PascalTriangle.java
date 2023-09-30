/**
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * Time Complexity: O()
 * Space Complexity: O()
 * */
package misc;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    private List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < numRows; ++i) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; ++j) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            result.add(new ArrayList<>(row));
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new PascalTriangle().generate(n));
    }
}
