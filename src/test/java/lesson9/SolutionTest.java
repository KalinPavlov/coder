package lesson9;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testFindTheUniqueNumber() {
        int[] input = {4, 3, 2, 4, 1, 3, 2};

        int actual = Solution.findTheUniqueNumber(input);

        Assert.assertEquals(1, actual);
    }
}
