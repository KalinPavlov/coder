package lesson14;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testSearchWord() {
        char[][] arr = {{'F', 'A', 'c', 'I'},
                        {'O', 'B', 'Q', 'P'},
                        {'A', 'N', 'O', 'B'},
                        {'M', 'A', 'S', 'S'}};

        Assert.assertTrue(Solution.wordSearch(arr, "FOAM"));
    }
}
