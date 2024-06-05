/**
 * author: akhilpathivada
 * time: 05/06/24 15:26
 */
package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {

    private int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]); // sort the courses by their deadlines
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            maxHeap.add(course[0]);
            if (time > course[1]) {
                time -= maxHeap.poll();
            }
        }
        return maxHeap.size();
    }

    public static void main(String[] args) {
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(new CourseScheduleIII().scheduleCourse(courses));
    }
}
