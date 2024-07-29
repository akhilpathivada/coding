/**
 * date 29/07/24 16:29
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/count-number-of-teams/description/
 *
 */
package misc;

public class CountNumberOfTeams {

    private int numTeams(int[] rating) {
        final int n = rating.length;
        int count = 0;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if ((rating[i] < rating[j] && rating[j] < rating[k])
                            || (rating[i] > rating[j] && rating[j] > rating[k])) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] rating = {2, 5, 3, 4, 1};
        System.out.println(new CountNumberOfTeams().numTeams(rating));
    }
}
