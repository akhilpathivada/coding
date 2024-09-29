/**
 * author: akhilpathivada
 * time: 29/09/24 18:37
 *
 * https://leetcode.com/problems/cinema-seat-allocation/description/
 *
 */
package greedy;

import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocation {

    private final class RowAllocationInfo {

        private final int row;

        private boolean left;

        private boolean middle;

        private boolean right;

        private RowAllocationInfo(int row) {
            this.row = row;
            this.left = true;
            this.middle = true;
            this.right = true;
        }
    }

    private int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        final Map<Integer, RowAllocationInfo> rowAllocationInfoMap = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int column = seat[1];
            rowAllocationInfoMap.putIfAbsent(row, new RowAllocationInfo(row));
            if (column >= 2 && column <= 5) {
                rowAllocationInfoMap.get(row).left = false;
            }
            if (column >= 4 && column <= 7) {
                rowAllocationInfoMap.get(row).middle = false;
            }
            if (column >= 6 && column <= 9) {
                rowAllocationInfoMap.get(row).right = false;
            }
        }
        int result = 0;
        for (RowAllocationInfo rowAllocationInfo : rowAllocationInfoMap.values()) {
            result += Math.max((rowAllocationInfo.left ? 1 : 0) + (rowAllocationInfo.right ? 1 : 0),
                    (rowAllocationInfo.middle ? 1 : 0));
        }
        result += (n - rowAllocationInfoMap.size()) * 2;
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] reservedSeats = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        System.out.println(new CinemaSeatAllocation().maxNumberOfFamilies(n, reservedSeats));
    }
}
