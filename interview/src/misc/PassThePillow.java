/**
 * author: akhilpathivada
 * time: 06/07/24 08:58
 *
 * https://leetcode.com/problems/pass-the-pillow/description/
 *
 */
package misc;

public class PassThePillow {

    private int passThePillow(int n, int time) {
        return n - Math.abs(n - 1 - time % (n * 2 - 2));
    }

    public static void main(String[] args) {
        int n = 4, time = 5;
        System.out.println(new PassThePillow().passThePillow(n, time));
    }
}
