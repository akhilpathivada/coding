/**
 * @author akhilpathivada
 * <p>
 * date : 25/12/23
 * time: 13:30
 *
 * https://www.codingninjas.com/studio/problems/nth-root-of-m_1062679
 *
 * Time Complexity: O(log(m) * log(n))
 * Space Complexity: O(1)
 */
package binarysearch;

public class FindNthRootOfM {

    private int NthRoot(int n, int m) {
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = (int) Math.pow(mid, n);
            if (value == m) {
                return mid;
            } else if (value < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3, m = 27;
        System.out.println(new FindNthRootOfM().NthRoot(n, m));
    }
}
