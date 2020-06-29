package lesson1;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testValidBST() {
        Node tree = new Node(5, new Node(4), new Node(7));

        Assert.assertTrue(Solution.isValidBSTRec(tree));
    }

    @Test
    public void testInvalidBST() {
        Node tree = new Node(5, new Node(4), new Node(7));
        tree.getRight().setLeft(new Node(2));

        Assert.assertFalse(Solution.isValidBSTRec(tree));
    }
}
