/**
 * author: akhilpathivada
 * time: 12/05/24 07:39
 */
package binarysearch;

import java.util.Arrays;

public class MinimizedMaximumOfProductsDistributedToAnyStore {

    private boolean canDistribute(int amount, int n, int[] quantities) {
        int countOfStoresGotDistribution = 0;
        for (int quantity : quantities) {
            countOfStoresGotDistribution += (int) Math.ceil((double) quantity / (double) amount));
        }
        return countOfStoresGotDistribution <= n;
    }

    private int minimizedMaximum(int n, int[] quantities) {
        int left = 1; // min. amount any store can get
        int right = Arrays.stream(quantities).max().getAsInt(); // max. amount any store can get
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(mid, n, quantities)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] quantities = {11, 6};
        System.out.println(new MinimizedMaximumOfProductsDistributedToAnyStore().minimizedMaximum(n, quantities));
    }
}
