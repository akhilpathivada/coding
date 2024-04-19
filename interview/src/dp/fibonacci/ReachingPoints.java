package dp.fibonacci;

/**
 * Date 19/04/24
 * Time 14:33
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/reaching-points/description/
 *
 */
public class ReachingPoints {

    private boolean f(int sx, int sy, final int tx, final int ty) {
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx && sy == ty) {
            return true;
        }
        return f(sx, sx + sy, tx, ty) || f(sx + sy, sy, tx, ty);
    }

    private boolean reachingPoints(int sx, int sy, int tx, int ty) {
        return f(sx, sy, tx, ty);
    }

    public static void main(String[] args) {
        int sx = 1, sy = 1, tx = 3, ty = 5;
        System.out.println(new ReachingPoints().reachingPoints(sx, sy, tx, ty));
    }
}
