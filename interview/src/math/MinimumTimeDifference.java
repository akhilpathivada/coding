/**
 * author: akhilpathivada
 * time: 26/09/24 09:55
 *
 * https://leetcode.com/problems/minimum-time-difference/description/
 *
 */
package math;

import java.util.*;

public class MinimumTimeDifference {

    private int findMinDifference(List<String> timePoints) {
        final List<Integer> minutesList = new ArrayList<>();
        for (String timePoint : timePoints) {
            int hour = Integer.parseInt(timePoint.substring(0, 2));
            int minute = Integer.parseInt(timePoint.substring(3));
            int minutes = hour * 60 + minute;
            minutesList.add(minutes);
        }
        Collections.sort(minutesList);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < minutesList.size(); ++i) {
            result = Math.min(result, minutesList.get(i) - minutesList.get(i - 1));
        }
        // handle the circular case (difference between the first and last time points
        return Math.min(result, 1440 + minutesList.get(0) - minutesList.get(minutesList.size() - 1));
    }

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>(Arrays.asList("23:59","00:00"));
        System.out.println(new MinimumTimeDifference().findMinDifference(timePoints));
    }
}
