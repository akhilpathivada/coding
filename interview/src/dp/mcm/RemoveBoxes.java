package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveBoxes {
    static int z = 0;
    private int f(Map<Integer, Integer> map, int i, int j) {
        // base case
        if (i > j) {
            return 0;
        }

        int maxPoints = Integer.MIN_VALUE;
        for (int k = i; k <= j; ++k) {

            int points = Math.max(map.get(i) * map.get(i),  f(map, i, k - 1) + f(map, k + 1, j));

            System.out.println("points - k - i - j : " + points + " - " + k + "- " + i + "- " + j);
            maxPoints = Math.max(maxPoints, points);
        }
        return maxPoints;
    }

    private int removeBoxes(int[] boxes) {
        int n = boxes.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i < n; ++i) {
            if (boxes[i] == boxes[i - 1]) {
                map.put(i, map.get(i - 1) + 1);
            } else {
                map.put(i, 1);
            }
        }
        // recursion
        System.out.println(f( map, 0, n - 1));

        System.out.println(Arrays.asList(map.values()));
        return 1;
    }

    public static void main(String[] args) {
//        int[] boxes = { 1, 3, 2, 2, 2, 3, 4, 3, 1 };
        int[] boxes = { 1, 1,1 };
        System.out.println(new RemoveBoxes().removeBoxes(boxes));
    }
}
