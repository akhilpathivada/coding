/**
 * @author akhilpathivada
 * <p>
 * date : 25/12/23
 * time: 08:23
 *
 * https://www.codingninjas.com/studio/problems/painter-s-partition-problem_1089557
 *
 * Time Complexity:  O(N * log(sum(arr[]) - max(arr[]) + 1))
 * Space Complexity: O(1)
 */
package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PaintersPartition {

    private int countPainters(ArrayList<Integer> boards, int pages) {
        int students = 1;
        int boardsPainterCanGet = 0;
        for (int i = 0; i < boards.size(); ++i) {
            if (boardsPainterCanGet + boards.get(i) <= pages) {
                // add pages to current student
                boardsPainterCanGet += boards.get(i);
            } else { // add pages to next student
                ++students;
                boardsPainterCanGet = boards.get(i);
            }
        }
        return students;
    }

    private int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        // impossible partition
        if (k > boards.size()) {
            return -1;
        }
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int painters = countPainters(boards, mid);
            if (painters > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        ArrayList<Integer> boards = new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2,3 ));
        int k = 2;
        System.out.println(new PaintersPartition().findLargestMinDistance(boards, k));
    }
}
