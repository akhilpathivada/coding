/**
 * author: akhilpathivada
 * time: 11/10/24 22:32
 *
 * https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description/
 *
 */
package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheNumberOfTheSmallestUnoccupiedChair {

    private final class ChairInfo {

        private final int friend;

        private final int startTime;

        private final int endTime;

        private int chairNumber;

        private ChairInfo(int friend, int startTime, int endTime) {
            this.friend = friend;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        private void setChairNumber(int chairNumber) {
            this.chairNumber = chairNumber;
        }
    }

    private int smallestChair(int[][] times, int targetFriend) {
        final int n = times.length;
        final ChairInfo[] chairInfos = new ChairInfo[n];
        final PriorityQueue<Integer> available = new PriorityQueue<>();
        final PriorityQueue<ChairInfo> occupied = new PriorityQueue<>((a, b) -> a.endTime - b.endTime);
        for (int i = 0; i < n; ++i) {
            chairInfos[i] = new ChairInfo(i, times[i][0], times[i][1]);
            available.add(i);
        }
        Arrays.sort(chairInfos, (a, b) -> a.startTime - b.startTime);
        for (int i = 0; i < n; ++i) {
            ChairInfo current = chairInfos[i];
            while (!occupied.isEmpty() && occupied.peek().endTime <= current.startTime) {
                available.add(occupied.poll().chairNumber);
            }
            current.setChairNumber(available.poll());
            occupied.add(current);
            if (current.friend == targetFriend) {
                return current.chairNumber;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] times = {{3, 10}, {1, 5}, {2, 6}};
        int targetFriend = 0;
        System.out.println(new TheNumberOfTheSmallestUnoccupiedChair().smallestChair(times, targetFriend));
    }
}
