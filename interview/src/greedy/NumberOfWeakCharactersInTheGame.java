/**
 * https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/description/
 *
 * Time Complexity: O(N * log(N))
 * Space Complexity: O(N * log(N))
 * */
package greedy;

import java.util.Arrays;

public class NumberOfWeakCharactersInTheGame {

    private int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        // b[1], a[1] because we need the 2nd values in descending order
        Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int noOfWeakCharacters = 0;
        int max = properties[n - 1][1];
        for (int i = n - 2; i >= 0; --i) {
            if (max > properties[i][1]) {
                ++noOfWeakCharacters;
            } else {
                max = properties[i][1];
            }
        }
        return noOfWeakCharacters;
    }

    public static void main(String[] args) {
        int[][] properties = { { 5, 5 }, { 6, 3 }, { 3, 6 } };
        System.out.println(new NumberOfWeakCharactersInTheGame().numberOfWeakCharacters(properties));
    }
}
