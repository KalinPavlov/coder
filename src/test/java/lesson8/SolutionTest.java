package lesson8;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {

    @Test
    public void testQueueSorted() {
        List<Person> people = new ArrayList<>();
        people.add(new Person(7, 0));
        people.add(new Person(4, 4));
        people.add(new Person(7, 1));
        people.add(new Person(5, 0));
        people.add(new Person(6, 1));
        people.add(new Person(5, 2));

        List<Person> expected = new ArrayList<>();
        expected.add(new Person(5, 0));
        expected.add(new Person(7, 0));
        expected.add(new Person(5, 2));
        expected.add(new Person(6, 1));
        expected.add(new Person(4, 4));
        expected.add(new Person(7, 1));

        List<Person> actual = Solution.recostructQueue(people);

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
