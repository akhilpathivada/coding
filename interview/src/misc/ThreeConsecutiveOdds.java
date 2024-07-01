/**
 * author: akhilpathivada
 * time: 01/07/24 07:58
 *
 * https://leetcode.com/problems/three-consecutive-odds/
 *
 */
package misc;

public class ThreeConsecutiveOdds {

    private boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count = 0;
            } else if (++count == 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 34, 3, 4, 5, 7, 23, 12};
        System.out.println(new ThreeConsecutiveOdds().threeConsecutiveOdds(arr));
    }
}
