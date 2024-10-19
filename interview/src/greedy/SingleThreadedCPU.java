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

    // Comparator to prioritize tasks by processing time, then by index if times are equal
    private static final Comparator<Task> taskComparator = (a, b) -> {
        if (a.processingTime == b.processingTime) {
            return Integer.compare(a.index, b.index);
        }
        return Integer.compare(a.processingTime, b.processingTime);
    };

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        List<Task> taskList = buildTaskList(tasks);
        sortTasksByEnqueueTime(taskList);
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(taskComparator);
        List<Integer> result = new ArrayList<>();
        int currentTime = 0;
        int taskIndex = 0;
        while (result.size() < n) { // Process all tasks
            taskIndex = processTasks(taskList, currentTime, taskQueue, taskIndex);
            currentTime = executeTask(taskQueue, taskList, taskIndex, result, currentTime);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    // Build task list from input array
    private List<Task> buildTaskList(final int[][] tasks) {
        List<Task> taskList = new ArrayList<>();
        IntStream.range(0, tasks.length)
                .forEach(i -> taskList.add(new Task(i, tasks[i][0], tasks[i][1])));
        return taskList;
    }

    // Sort task list based on enqueue time
    private void sortTasksByEnqueueTime(final List<Task> taskList) {
        taskList.sort(Comparator.comparingInt(task -> task.enqueueTime));
    }

    // Process tasks that are ready to be executed based on current time
    private int processTasks(final List<Task> taskList, final int currentTime,
                             final PriorityQueue<Task> taskQueue, int taskIndex) {
        while (taskIndex < taskList.size() && taskList.get(taskIndex).enqueueTime <= currentTime) {
            taskQueue.offer(taskList.get(taskIndex++));
        }
        return taskIndex;
    }

    // Execute the next task in the priority queue and update current time
    private int executeTask(final PriorityQueue<Task> taskQueue, final List<Task> taskList, final int taskIndex,
                            final List<Integer> result, int currentTime) {
        if (taskQueue.isEmpty()) { // If the queue is empty, advance time to the next task's enqueue time
            currentTime = taskList.get(taskIndex).enqueueTime;
        } else { // Process the task with the shortest processing time
            Task task = taskQueue.poll();
            currentTime += task.processingTime;
            result.add(task.index);
        }
        return currentTime;
    }

    public static void main(String[] args) {
        int[][] tasks = {{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
        System.out.println(Arrays.toString(new SingleThreadedCPU().getOrder(tasks)));
    }
}
