/**
 * https://leetcode.com/problems/permutation-sequence/description/
 * */
package math;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    private String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; ++i) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        StringBuilder ans = new StringBuilder();
        --k;
        while (true) {
            ans.append(numbers.get(k / fact));
            numbers.remove(k /fact);
            if (numbers.isEmpty()) {
                break;
            }
            k %= fact;
            fact /= numbers.size();
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int n = 4, k = 9;
        System.out.println(new PermutationSequence().getPermutation(n, k));
    }
}
