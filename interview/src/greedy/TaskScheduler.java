/**
 * https://leetcode.com/problems/task-scheduler/
 *
 * Time Complexity : O(C) -> Constant time to sort array of 26 chars length
 * Space Complexity : O(C)
 * */
package greedy;

import java.util.Arrays;

public class TaskScheduler {
	private int leastInterval(char[] tasks, int n) {
		// store frequencies of the tasks
		int[] frequencies = new int[26];
		for (int i = 0; i < tasks.length; ++i) {
			frequencies[tasks[i] - 'A']++;
		}
		Arrays.sort(frequencies);
		int maxFrequency = frequencies[25];
		int idleTime = (maxFrequency - 1) * n;
		for (int i = frequencies.length - 2; i >= 0 && idleTime > 0; --i) {
			idleTime -= Math.min(maxFrequency - 1, frequencies[i]);
		}
		idleTime = Math.max(0, idleTime);
		return idleTime + tasks.length;
	}
	public static void main(String[] args) {
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n = 2;
		System.out.println(new TaskScheduler().leastInterval(tasks, n));
	}
}
