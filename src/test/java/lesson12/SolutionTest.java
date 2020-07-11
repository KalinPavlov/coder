package lesson12;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testDominoes() {
        char[] input = {'.', '.', 'R', '.', '.', '.', 'L', '.', '.', 'R', '.'};

        char[] expected = {'.', '.', 'R', 'R', '.', 'L', 'L', '.', '.', 'R', 'R'};

        Assert.assertArrayEquals(expected, Solution.pushDominoes(input));
    }

    @Test
    public void testDominoes1() {
        char[] input = {'R', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'};

        char[] expected = {'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R'};

        Assert.assertArrayEquals(expected, Solution.pushDominoes(input));
    }

    @Test
    public void testDominoes2() {
        char[] input = {'R', '.', 'L', 'L', 'R', '.', 'R', '.', '.', '.', 'L'};

        char[] expected = {'R', '.', 'L', 'L', 'R', 'R', 'R', 'R', '.', 'L', 'L'};

        Assert.assertArrayEquals(expected, Solution.pushDominoes(input));
    }
}
