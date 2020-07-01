package lesson5;

public class Solution {

    public static int[] getRangeRec(int[] arr, int target) {
        int low = binarySearchRec(arr, 0, arr.length , target, true);
        int high = binarySearchRec(arr, 0, arr.length , target, false);

        return new int[]{low, high};
    }

    public static int[] getRangeIter(int[] arr, int target) {
        int low = binarySearchIter(arr, target, true);
        int high = binarySearchIter(arr, target, false);

        return new int[]{low, high};
    }

    public static int binarySearchRec(int[] arr, int low, int high, int target, boolean findFirst) {
        if (high < low) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (findFirst) {
            if ((mid == 0 || target > arr[mid - 1]) && arr[mid] == target) {
                return mid;
            }

            if (target > arr[mid]) {
                return binarySearchRec(arr, mid + 1, high, target, findFirst);
            } else {
                return binarySearchRec(arr, low, mid - 1, target, findFirst);
            }
        } else {
            if ((mid == arr.length - 1 || target < arr[mid + 1]) && arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                return  binarySearchRec(arr, low, mid - 1, target, findFirst);
            } else {
                return  binarySearchRec(arr, mid + 1, high, target, findFirst);
            }
        }
    }

    public static int binarySearchIter(int[] arr, int target, boolean findFirst) {
        if (arr == null) { return -1; }

        int low = 0;
        int high = arr.length;
        int mid;

        while (low < high) {
            mid = low + (high - low) / 2;

            if (findFirst) {
                if ((mid == 0 || target > arr[mid - 1]) && arr[mid] == target) {
                    return mid;
                }

                if (target > arr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if ((mid == arr.length - 1 || target < arr[mid + 1]) && arr[mid] == target) {
                    return mid;
                } else if (target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

    @SuppressWarnings("unused")
    public static int standardBinarySearchRec(int[] arr, int target) {
        return standardBinarySearchRecHelper(arr, 0, arr.length - 1, target);
    }

    public static int standardBinarySearchRecHelper(int[] arr, int low, int high, int target) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            if (target < arr[mid]) {
                return standardBinarySearchRecHelper(arr, low, mid - 1, target);
            } else {
                return standardBinarySearchRecHelper(arr, mid + 1, high, target);
            }
        } else {
            return -1;
        }
    }
}
