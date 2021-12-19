package SortByNameAndAge1;

import java.util.Comparator;

public class ComparatorPerson implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {

        int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

        if (sComp != 0) {
            return sComp;
        } else {
            return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
        }
    }
}
