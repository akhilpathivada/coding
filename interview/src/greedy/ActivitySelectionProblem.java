/**
 * Date 08/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
 *
 * Time Complexity : O(n * log(n))
 * Space Complexity : O(n)
 *
 */
package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionProblem {

    private static final class Activity {

        private final int startTime;

        private final int finishTime;

        private Activity(int startTime, int finishTime) {
            this.startTime = startTime;
            this.finishTime = finishTime;
        }
    }

    private void maxActivities(Activity[] activities, int n) {
        Arrays.sort(activities, (a, b) -> a.finishTime - b.finishTime); // Sort activities by finish time
        System.out.println("Selected activities:");
        int lastSelected = 0; // Select the first activity
        System.out.println("(" + activities[lastSelected].startTime + ", " + activities[lastSelected].finishTime + ")");
        for (int i = 1; i < n; ++i) {
            if (activities[i].startTime >= activities[lastSelected].finishTime) { // Select the activity if it's
                // start time is greater or equal to the last selected finish time
                System.out.println("(" + activities[i].startTime + ", " + activities[i].finishTime + ")");
                lastSelected = i;
            }
        }
    }

    public static void main(String[] args) {
        // Initialize activities
        Activity[] activities = {
                new Activity(5, 9),
                new Activity(1, 2),
                new Activity(3, 4),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(8, 9)
        };
        new ActivitySelectionProblem().maxActivities(activities, activities.length);
    }
}
