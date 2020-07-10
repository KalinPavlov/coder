package lesson11;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    @Test
    public void testCanFinish() {
        List<int[]> input = Arrays.asList(new int[]{1, 0});

        Assert.assertTrue(Solution.canFinish(input));
    }

    @Test
    public void testCanFinish1() {
        List<int[]> input = Arrays.asList(new int[]{1, 0}, new int[]{0, 1});

        Assert.assertFalse(Solution.canFinish(input));
    }
}
