/**
 * author: akhilpathivada
 * time: 20/06/24 08:16
 *
 * https://leetcode.com/problems/magnetic-force-between-two-balls/description/
 *
 */
package binarysearch;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

    private boolean canPlaceMBalls(int[] position, int m, int distance) {
        int prev = position[0]; // position of previous ball
        int ballsPlaced = 1;
        for (int current : position) {
            if (current - prev >= distance) {
                prev = current;
                ++ballsPlaced;
            }
        }
        return ballsPlaced >= m;
    }

    private int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 0;
        int right = position[position.length - 1];
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlaceMBalls(position, m, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
        System.out.println(new MagneticForceBetweenTwoBalls().maxDistance(position, m));
    }
}
