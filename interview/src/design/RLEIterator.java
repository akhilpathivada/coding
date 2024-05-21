/**
 * author: akhilpathivada
 * time: 21/05/24 12:31
 *
 * https://leetcode.com/problems/rle-iterator/
 *
 */
package design;

public class RLEIterator {

    private final int[] rle;

    private int iterator;

    public RLEIterator(int[] encoding) {
        this.rle = encoding;
        this.iterator = 0;
    }

    public int next(int n) {
        while (iterator < rle.length) {
            if (rle[iterator] >= n) {
                rle[iterator] -= n;
                return rle[iterator + 1];
            } else {
                n -= rle[iterator];
                iterator += 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RLEIterator rLEIterator = new RLEIterator(new int[]{3, 8, 0, 9, 2, 5}); // This maps to the sequence [8,8,8,5,5].
        System.out.println(rLEIterator.next(2)); // exhausts 2 terms of the sequence, returning 8. The remaining sequence is now [8, 5, 5].
        System.out.println(rLEIterator.next(1)); // exhausts 1 term of the sequence, returning 8. The remaining sequence is now [5, 5].
        System.out.println(rLEIterator.next(1)); // exhausts 1 term of the sequence, returning 5. The remaining sequence is now [5].
        System.out.println(rLEIterator.next(2)); // exhausts 2 terms, returning -1. This is because the first term exhausted was 5,
        // but the second term did not exist. Since the last term exhausted does not exist, we return -1.
    }
}
