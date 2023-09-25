package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LetterCombinationsOfAPhoneNumber {

    private static Map<Character, String> digitToLetters = new HashMap<>();
    private static List<String> result = new ArrayList<>();

    private static void generateCombinations(String digits, int currentIndex, StringBuilder currentCombination) {

        if (currentIndex == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        char currentDigit = digits.charAt(currentIndex);
        String letterOptions = digitToLetters.get(currentDigit);

        if (Objects.nonNull(letterOptions)) {
            for (int i = 0; i < letterOptions.length(); ++i) {
                char letter = letterOptions.charAt(i);
                currentCombination.append(letter);
                generateCombinations(digits, currentIndex + 1, currentCombination);
                currentCombination.deleteCharAt(currentCombination.length() - 1);
            }
        }
    }

    private static List<String> letterCombinations(String digits) {

        if (digits == null || digits.isEmpty()) {
            return result;
        }
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        generateCombinations(digits, 0, new StringBuilder());

        return result;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
