package lesson2;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static boolean canSpell(char[] arr, String word) {
        final Map<Character, Integer> chars = new HashMap<>(); // 1
        for (char ch : arr) { // n
            int count = chars.containsKey(ch) ? chars.get(ch) + 1 : 1; // 1
            chars.put(ch, count); // 1
        }

        for (char ch : word.toCharArray()) { //n
            if (!chars.containsKey(ch) || chars.get(ch) == 0) { // 1
                return false; // 1
            }
            chars.put(ch, chars.get(ch) - 1); // 1
        }

        return true; // 1
    }
}
