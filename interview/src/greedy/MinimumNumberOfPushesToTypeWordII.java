/**
 * date 06/08/24 13:05
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/description/
 *
 */
package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class MinimumNumberOfPushesToTypeWordII {

    private int minimumPushes(String word) {
        final Integer[] count = Arrays.stream(new int[26]).boxed().toArray(Integer[]::new);
        word.chars().forEach(i -> count[i - 'a']++);
        Arrays.sort(count, Collections.reverseOrder());
        return IntStream.range(0, 26).reduce(0, (presses, i) -> presses + ((i / 8 + 1) * count[i]));
    }

    public static void main(String[] args) {
        String word = "aabbccddeeffgghhiiiiii";
        System.out.println(new MinimumNumberOfPushesToTypeWordII().minimumPushes(word));
    }
}
