/**
 * author: akhilpathivada
 * time: 24/05/24 07:48
 *
 * https://leetcode.com/problems/lemonade-change/description/
 *
 */
package greedy;

public class LemonadeChange {

    private boolean lemonadeChange(int[] bills) {
        int fivesInHand = 0;
        int tensInHand = 0;
        for (int bill : bills) {
            if (bill == 5) {
                ++fivesInHand;
            } else if (bill == 10) {
                --fivesInHand;
                ++tensInHand;
            } else if (tensInHand > 0) {
                --tensInHand;
                --fivesInHand;
            } else {
                fivesInHand -= 3;
            }
            if (fivesInHand < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println(new LemonadeChange().lemonadeChange(bills));
    }
}
