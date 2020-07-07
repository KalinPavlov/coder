package lesson10;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testReverse() {
        Node list = new Node(4, new Node(3, new Node(2, new Node(1, new Node(0)))));
        Node expected = new Node(0, new Node(1, new Node(2, new Node(3, new Node(4)))));

        Node actual = Solution.reverse(list);
        Assert.assertArrayEquals(expected.toList().toArray(), actual.toList().toArray());
    }

    @Test
    public void testReverseRec() {
        Node list = new Node(4, new Node(3, new Node(2, new Node(1, new Node(0)))));
        Node expected = new Node(0, new Node(1, new Node(2, new Node(3, new Node(4)))));

        Node actual = Solution.reverseRec(list);
        Assert.assertArrayEquals(expected.toList().toArray(), actual.toList().toArray());
    }
}
