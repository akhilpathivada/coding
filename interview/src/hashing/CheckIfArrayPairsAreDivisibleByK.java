/**
 * author: akhilpathivada
 * time: 01/10/24 07:22
 *
 * https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description/
 *
 */
package hashing;

public class CheckIfArrayPairsAreDivisibleByK {

    // logic: https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/solutions/709691/java-7ms-simple-solution/
    private boolean canArrange(int[] arr, int k) {
        final int[] frequency = new int[k]; // tracks freq. of possible remainders when dividing with k
        for (int num : arr) {
            int remainder = num % k;
            if (remainder < 0) {
                remainder += k;
            }
            frequency[remainder]++;
        }
        if (frequency[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i <= k / 2; ++i) {
            if (frequency[i] != frequency[k - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k = 5;
        System.out.println(new CheckIfArrayPairsAreDivisibleByK().canArrange(arr, k));
    }
}
