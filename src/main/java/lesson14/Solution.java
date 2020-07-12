package lesson14;

public class Solution {

    public static boolean wordSearch(char[][] arr, String word) {
        for (int index = 0; index < arr.length; index++) {
            if (wordSearchHorizontal(arr, index, word.toCharArray())) {
                return true;
            }
        }
        for (int index = 0; index < arr[0].length; index++) {
            if (wordSearchVertical(arr, index, word.toCharArray())) {
                return true;
            }
        }

        return false;
    }

    private static boolean wordSearchHorizontal(char[][] arr, int rowIndex, char[] word) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[rowIndex][index] != word[index]) {
                return false;
            }
        }
        return true;
    }

    private static boolean wordSearchVertical(char[][] arr, int colIndex, char[] word) {
        for (int index = 0; index < arr[0].length; index++) {
            if (arr[index][colIndex] != word[index]) {
                return false;
            }
        }
        return true;
    }
}
