package lesson8;

import java.util.Objects;

public class Person {
    private int height;
    private int peopleSees;

    public Person(int height, int peopleSees) {
        this.height = height;
        this.peopleSees = peopleSees;
    }

    public int getHeight() {
        return height;
    }

    public int getPeopleSees() {
        return peopleSees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return height == person.height &&
                peopleSees == person.peopleSees;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, peopleSees);
    }
}
