package lesson4;

import java.util.*;

public class Solution {

    public static List<int[]> twoSum(int[] arr, int target) {
        final List<int[]> result = new ArrayList<>(); // 1

        if (arr == null) { // 1
            return result; // 1
        }

        final Map<Integer, Integer> lookupTable = new HashMap<>(); // 1
        for (int index = 0; index < arr.length; index++) { // n
            lookupTable.put(arr[index], index);
        }

        for (int index = 0; index < arr.length; index++) { // n
            int value = arr[index]; // 1
            if (value < target) { // 1
                int required = target - value; // 1
                if (lookupTable.containsKey(required)) { // 1
                    result.add(new int[]{index, lookupTable.get(required)}); // 1
                    lookupTable.remove(arr[index]); // 1
                    lookupTable.remove(required); // 1
                }
            }
        }

        return result; // 1
    }
}
