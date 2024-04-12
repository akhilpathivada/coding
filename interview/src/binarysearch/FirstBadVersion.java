package binarysearch;

/**
 * Date 12/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/first-bad-version/
 */
public class FirstBadVersion {

    boolean isBadVersion(int version) {
        return version >= 4;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new FirstBadVersion().firstBadVersion(n));
    }
}
