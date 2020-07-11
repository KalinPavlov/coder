package lesson13;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testASTOperation() {
        Expr expr = new Add(new Val(1), new Add(new Val(2), new Add(new Val(3), new Add(new Val(4), new Val(5)))));

        Assert.assertEquals(15, expr.evaluate());
    }

    @Test
    public void testASTOperatio1() {
        Expr expr = new Negate(new Add(new Val(3), new Subtract(new Val(2), new Val(1))));

        Assert.assertEquals(-4, expr.evaluate());
    }
}
