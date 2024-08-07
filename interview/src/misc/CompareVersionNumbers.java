/**
 * date 07/08/24 16:14
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/compare-version-numbers/description/
 *
 */
package misc;

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        final String[] v1 = version1.split("\\.");
        final String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); ++i) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.01", version2 = "1.001";
        System.out.println(new CompareVersionNumbers().compareVersion(version1, version2));
    }
}
