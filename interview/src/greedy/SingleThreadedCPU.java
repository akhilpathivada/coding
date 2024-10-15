/**
 * date 15/10/24 09:58
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/single-threaded-cpu/description/
 * 
 */
package greedy;

import java.util.*;
import java.util.stream.IntStream;

public class SingleThreadedCPU {

    private final class Task {

        private final int index;

        private final int enqueueTime;

        private final int processingTime;

        private Task(int index, int enqueueTime, int processingTime) {
            this.index = index;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }

    private int[] getOrder(int[][] tasks) {
        final int n = tasks.length;
        final List<Task> taskList = new ArrayList<>();
        final List<Integer> result = new ArrayList<>();
        final PriorityQueue<Task> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.processingTime == b.processingTime) {
                return Integer.compare(a.index, b.index);
            }
            return Integer.compare(a.processingTime, b.processingTime);
        });
        IntStream.range(0, n).forEach(i -> taskList.add(new Task(i, tasks[i][0], tasks[i][1]))); // Add tasks to list
        taskList.sort((a, b) -> Integer.compare(a.enqueueTime, b.enqueueTime)); // Sort taskList based on `enqueueTime`
        int currentTime = 0;
        int index = 0; // Tracks the current task's index
        while (result.size() < n) {
            while (index < n && taskList.get(index).enqueueTime <= currentTime) {
                minHeap.offer(taskList.get(index++));
            }
            if (minHeap.isEmpty()) {
                currentTime = taskList.get(index).enqueueTime;
            } else {
                Task task = minHeap.poll();
                currentTime += task.processingTime;
                result.add(task.index);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[][] tasks = {{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
        System.out.println(Arrays.toString(new SingleThreadedCPU().getOrder(tasks)));
    }
}
