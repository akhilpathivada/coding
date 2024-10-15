/**
 * author: akhilpathivada
 * time: 15/10/24 07:32
 *
 * https://leetcode.com/problems/separate-black-and-white-balls/description/
 */
package greedy;

public class SeparateBlackAndWhiteBalls {

    private long minimumSteps(String s) {
        long result = 0;
        long blackBallsCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') { // White ball encountered, add the number of black balls on its left
                result += blackBallsCount;
            } else { // Black ball encountered, increment the black ball count
                ++blackBallsCount;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "100";
        System.out.println(new SeparateBlackAndWhiteBalls().minimumSteps(s));
    }
}
