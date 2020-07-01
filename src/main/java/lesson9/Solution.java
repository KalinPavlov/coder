package lesson9;

import java.util.*;

public class Solution {

    public static int findTheUniqueNumber(int[] arr) {
        Map<Integer, Integer> nums = new HashMap<>();

        for (int n : arr) {
            if (nums.containsKey(n)) {
                nums.put(n, nums.get(n) + 1);
            } else {
                nums.put(n, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : nums.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    @SuppressWarnings("unused")
    public static int findTheUniqueNumber2(int[] arr) {
        int unique = 0;
        for (int i : arr) {
            unique ^= i;
        }

        return unique;
    }
}
