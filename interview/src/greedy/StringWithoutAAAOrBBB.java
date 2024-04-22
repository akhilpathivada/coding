package greedy;

/**
 * Date 19/04/24
 * Time 22:15
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/string-without-aaa-or-bbb/description/
 *
 */
public class StringWithoutAAAOrBBB {

    private String strWithout3a3b(int a, int b) {
        StringBuilder result = new StringBuilder();
        while (a > 0 || b > 0) {
            if (result.toString().endsWith("aa")) {
                result.append('b');
                --b;
            } else if (result.toString().endsWith("bb")) {
                result.append('a');
                --a;
            } else if (a > b) {
                result.append('a');
                --a;
            } else {
                result.append('b');
                --b;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int a = 4, b = 1;
        System.out.println(new StringWithoutAAAOrBBB().strWithout3a3b(a, b));
    }
}
