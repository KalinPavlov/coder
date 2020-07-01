package lesson8;

import java.util.*;

public class Solution {

    public static List<Person> recostructQueue(List<Person> people) {
        people.sort(Comparator.comparing(Person::getHeight).reversed().thenComparing(Person::getPeopleSees));
        List<Person> result = new ArrayList<>();

        for (Person person : people) {
            result.add(person.getPeopleSees(), person);
        }

        return result;
    }
}
