/**
 * date 01/08/24 13:24
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/number-of-senior-citizens/description/
 */
package strings;

import java.util.Arrays;

public class NumberOfSeniorCitizens {

    private int countSeniors(String[] details) {
        return (int) Arrays.stream(details).filter(detail -> Integer.parseInt(detail.substring(11, 13)) > 60).count();
    }

    public static void main(String[] args) {
        String[] details = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
        System.out.println(new NumberOfSeniorCitizens().countSeniors(details));
    }
}
