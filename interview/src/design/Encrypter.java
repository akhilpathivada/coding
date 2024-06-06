/**
 * author: akhilpathivada
 * time: 06/06/24 14:14
 *
 * https://leetcode.com/problems/encrypt-and-decrypt-strings/
 *
 */
package design;

import java.util.HashMap;
import java.util.Map;

public class Encrypter {

    private final Map<Character, String> charToDictMap;

    private final Map<String, Integer> encryptedDictToCountMap;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        this.charToDictMap = new HashMap<>();
        this.encryptedDictToCountMap = new HashMap<>();
        for (int i = 0; i < keys.length; ++i) {
            charToDictMap.put(keys[i], values[i]);
        }
        for (String dict : dictionary) {
            String encrypt = encrypt(dict);
            encryptedDictToCountMap.put(encrypt, encryptedDictToCountMap.getOrDefault(encrypt, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder result = new StringBuilder();
        for (char c : word1.toCharArray()) {
            result.append(charToDictMap.getOrDefault(c, "#"));
        }
        return result.toString();
    }

    public int decrypt(String word2) {
        return encryptedDictToCountMap.getOrDefault(word2, 0);
    }
}
