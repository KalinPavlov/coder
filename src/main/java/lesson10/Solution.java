package lesson10;

public class Solution {

    public static Node reverse(Node node) {
        Node current = node;
        Node prev = null;

        while (current != null) { // n
            Node temp = current.getNext();
            current.setNext(prev);
            prev = current;
            current = temp;
        }

        return prev;
    }

    // Time: O(n)
    // Space: O(n)

    public static Node reverseRec(Node node) {
        return reverseHelper(node, null);
    }

    private static Node reverseHelper(Node current, Node prev) {
        if (current == null) {
            return prev;
        }

        Node temp = current.getNext();
        current.setNext(prev);

        return reverseHelper(temp, current);
    }
}
