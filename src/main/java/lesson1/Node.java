package lesson1;

/**
 * This Node represents a binary tree node.
 */
public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(final int value) {
        this.value = value;
    }

    public Node(final int value, final Node left, final Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
