/**
 * https://leetcode.com/problems/find-substring-with-given-hash-value/description/
 *
 * (Rolling Hash)
 *
 * Time Complexity: O(O(N))
 * Space Complexity: O(1)
 * */
package patternmatch.rollinghash;

public class FindSubstringWithGivenHashValue {

    private String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long currentHash = 0;
        long previousK = 1;
        int n = s.length();
        int resultIndex = 0;
        for (int i = n - 1; i >= 0; --i) {
            currentHash = (currentHash * power + s.charAt(i) - 'a' + 1) % modulo;
            if (i + k >= n) {
                previousK = previousK * power % modulo;
            } else {
                currentHash = (currentHash - (s.charAt(i + k) - 'a' + 1) * previousK % modulo + modulo) % modulo;
            }
            if (currentHash == hashValue) {
                resultIndex = i;
            }
        }
        return s.substring(resultIndex, resultIndex + k);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int power = 7, modulo = 20, k = 2, hashValue = 0;
        System.out.println(new FindSubstringWithGivenHashValue().subStrHash(s, power, modulo, k, hashValue));
    }
}
