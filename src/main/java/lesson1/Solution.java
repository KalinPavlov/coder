package lesson1;

public class Solution {

    public static boolean isValidBST(Node tree) {
        return isValidBSTHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBSTHelper(Node node, int low, int high) {
        if (node == null) {
            return true;
        }

        if (node.getValue() > low && node.getValue() < high) {
            return isValidBSTHelper(node.getLeft(), low, node.getValue()) &&
                    isValidBSTHelper(node.getRight(), node.getValue(), high);
        }

        return false;
    }
}
