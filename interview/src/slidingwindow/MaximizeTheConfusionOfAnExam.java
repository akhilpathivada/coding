package slidingwindow;

/**
 * Date 19/04/24
 * Time 16:40
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/
 *
 */
public class MaximizeTheConfusionOfAnExam {

    private int maxSubstringObtainsByFlippingTheChar(final String answerKey, final int k, final char charToFlip) {
        int left = 0;
        int count = 0;
        int length = Integer.MIN_VALUE;
        for (int right = 0; right < answerKey.length(); ++right) {
            count += answerKey.charAt(right) == charToFlip ? 1 : 0;
            while (count > k) {
                count -= answerKey.charAt(left++) == charToFlip ? 1 : 0;
            }
            length = Math.max(length, right - left + 1);
        }
        return length;
    }

    private int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxSubstringObtainsByFlippingTheChar(answerKey, k, 'T'), maxSubstringObtainsByFlippingTheChar(answerKey, k, 'F'));
    }

    public static void main(String[] args) {
        String answerKey = "TTFF";
        int k = 2;
        System.out.println(new MaximizeTheConfusionOfAnExam().maxConsecutiveAnswers(answerKey, k));
    }
}
