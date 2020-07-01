package lesson4;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void testTwoSum() {
        final int[] input = {2, 7, 11, 15};
        final int target = 18;

        final List<int[]> actual = Solution.twoSum(input, target);

        Assert.assertArrayEquals(new int[][]{{1, 2}}, actual.toArray());
    }

    @Test
    public void testTwoSum1() {
        final int[] input = {5, 2, 12, 1, 7, 9, 3, 11, 15};
        final int target = 8;

        final List<int[]> actual = Solution.twoSum(input, target);

        Assert.assertArrayEquals(new int[][]{{0, 6}, {3, 4}}, actual.toArray());
    }
}
