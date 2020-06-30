package lesson2;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testRansomNote1() {
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f'};

        Assert.assertTrue(Solution.canSpell(input, "bed"));
    }

    @Test
    public void testRansomNote2() {
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f'};

        Assert.assertFalse(Solution.canSpell(input, "cat"));
    }
}
