package lesson6;

import java.util.ArrayList;
import java.util.List;

// TODO not working
public class Solution {

    public static List<int[]> permute(int[] arr) {
        return permuteHelper(arr, 0);
    }

    private static List<int[]> permuteHelper(int[] arr, int start) {
        List<int[]> result = new ArrayList<>();
        if (start == arr.length - 1) {
            result.add(arr);
            return result;
        }

        for(int index = start; index < arr.length; index++) {
            swap(arr, start, index);
            result.addAll(permuteHelper(arr, start + 1));
            swap(arr, start, index);
        }

        return result;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
