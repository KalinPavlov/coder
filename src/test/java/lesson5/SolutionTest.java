package lesson5;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testGetRange() {
        int[] arr = {1, 3, 3, 5, 7, 8, 9, 9, 9, 15};

        int[] expected = {6, 8};

        int[] actual = Solution.getRangeRec(arr, 9);
        Assert.assertArrayEquals(expected, actual);

        actual = Solution.getRangeIter(arr, 9);
        Assert.assertArrayEquals(expected, actual);
    }
}
