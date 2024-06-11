/**
 * author: akhilpathivada
 * time: 11/06/24 17:20
 *
 * https://leetcode.com/problems/minimum-processing-time/description/
 *
 */
package greedy;

import java.util.Collections;
import java.util.List;

public class MinimumProcessingTime {

    private int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, Collections.reverseOrder());
        int i = 0;
        int result = 0;
        for (int p : processorTime) {
            for (int count = 0; count < 4; ++count) {
                result = Math.max(result, p + tasks.get(i++));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] processorTime = {8, 10};
        int[] tasks = {2, 2, 3, 1, 8, 7, 4, 5};
        // System.out.println(new MinimumProcessingTime().minProcessingTime(processorTime, tasks));
    }
}
