package lesson3;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>();

        Node current = this;
        while(current != null) {
            list.add(current.getValue());
            current = current.getNext();
        }

        return list;
    }
}
