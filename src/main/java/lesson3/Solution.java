package lesson3;

public class Solution {

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node result = null;
        Node currentResult = null;
        Node temp;

        int carryOver = 0;
        int sum;

        // We can sum if one of the two or the two are not null
        while (l1 != null || l2 != null) {
            // The sum is equal to value1 + value2 + the carryover
            sum = carryOver + (l1 != null ? l1.getValue() : 0) + (l2 != null ? l2.getValue() : 0);

            // The carryover depends on the division
            carryOver = sum / 10;

            // The remainder is the value that will be written in the new node
            int remainder = sum % 10;

            // We need a temp node to represent either the head of the list or one of the next nodes
            temp = new Node(remainder);

            // We either initialize the head of the list or add next node to the current
            if (result == null) {
                result = temp;
            } else {
                currentResult.setNext(temp);
            }

            currentResult = temp;

            // Set the next nodes to be processed.
            if (l1 != null) {
                l1 = l1.getNext();
            }

            if (l2 != null) {
                l2 = l2.getNext();
            }

        }

        // If we still have a carryover after all nodes have been traversed we add a new node with the carryover.
        if (carryOver > 0) {
            currentResult.setNext(new Node(carryOver));
        }

        return result;
    }
}
