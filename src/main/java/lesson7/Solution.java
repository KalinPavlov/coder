package lesson7;

public class Solution {

    public static int[] sortNums(int[] arr) {
        return sortNumsHelper(arr);
    }

    private static int[] sortNumsHelper(int[] arr) {
        int oneIndex = 0;
        int threeIndex = arr.length - 1;
        int index = 0;

        while (index <= threeIndex) {
            if (arr[index] == 1) {
                swap(arr, index, oneIndex);
                oneIndex++;
                index++;
            } else if (arr[index] == 2) {
                index++;
            } else if (arr[index] == 3) {
                swap(arr, index, threeIndex);
                threeIndex--;

            }
        }

        return arr;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
