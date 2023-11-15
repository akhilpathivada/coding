package slidingwindow;

public class LongestRepeatingCharacterReplacement {

    private int characterReplacement(String s, int k) {
        int lengthOfLongestSubstring = 1;
        char[] arr = s.toCharArray();
//        for (int i = 0; i < s.length(); ++i) {
//            char currentCharacter = s.charAt(i);
//            int lengthOfSubstring = 1;
//            int x = 1;
//            int j = 1;
//            while (j < s.length() && x <= k) {
//                if (s.charAt(j) != currentCharacter) {
//                    char prev = s.charAt(j);
//                    arr[j] = currentCharacter;
//                    lengthOfSubstring = Math.max(lengthOfLongestSubstring, findLengthOfSubstring())
//                    ++k;
//                }
//                ++j;
//            }
//            for (int j = 1; ; ++j) {
//
//            }
//        }
        return 1;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement(s, k));
    }
}
