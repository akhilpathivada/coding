/**
 * author: akhilpathivada
 * time: 08/05/24 20:38
 *
 * https://leetcode.com/problems/longest-turbulent-subarray/description/
 *
 */
package slidingwindow;

public class LongestTurbulentSubarray {

    public int maxTurbulenceSize(int[] arr) {
        char prev = 0;
        int left = 0;
        int result = 1;
        for (int right = 1; right < arr.length; ++right) {
            if (arr[right - 1] < arr[right] && prev != '<') {
                prev = '<';
                result = Math.max(result, right - left + 1);
            } else if (arr[right - 1] > arr[right] && prev != '>') {
                prev = '>';
                result = Math.max(result, right - left + 1);
            } else {
                prev = 0;
                right -= arr[right - 1] != arr[right] ? 1 : 0;
                left = right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(new LongestTurbulentSubarray().maxTurbulenceSize(arr));
    }
}
