/**
 * author: akhilpathivada
 * time: 13/06/24 07:43
 *
 * https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/
 *
 */
package greedy;

import java.util.Arrays;
import java.util.Map;

public class MinimumNumberOfMovesToSeatEveryone {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; ++i) {
            moves += Math.abs(seats[i] - students[i]);
        }
        return moves;
    }

    public static void main(String[] args) {
        int[] seats = {4, 1, 5, 9};
        int[] students = {1, 3, 2, 6};
        System.out.println(new MinimumNumberOfMovesToSeatEveryone().minMovesToSeat(seats, students));
    }
}
