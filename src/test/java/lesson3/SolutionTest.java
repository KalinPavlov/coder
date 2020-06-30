package lesson3;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testSum() {
        Node l1 = new Node(2, new Node(4, new Node(3)));
        Node l2 = new Node(5, new Node(6, new Node(4)));

        Node actual = Solution.addTwoNumbers(l1, l2);
        Node expected = new Node(7, new Node(0, new Node(8)));
        Assert.assertArrayEquals(expected.toList().toArray(), actual.toList().toArray());
    }

    @Test
    public void testSum1() {
        Node l1 = new Node(2, new Node(4, new Node(3)));
        Node l2 = new Node(5, new Node(6, new Node(7)));

        Node actual = Solution.addTwoNumbers(l1, l2);
        Node expected = new Node(7, new Node(0, new Node(1, new Node(1))));
        Assert.assertArrayEquals(expected.toList().toArray(), actual.toList().toArray());
    }
}
