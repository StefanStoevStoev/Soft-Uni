package StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Set<Person> peopleByAge = new TreeSet<>(new PersonComparatorByAge());
        Set<Person> peopleByName = new TreeSet<>(new PersonByName());

        while (n-- > 0) {
            String[] input = scan.nextLine().split("\\s+");
            Person p = new Person(input[0], Integer.parseInt(input[1]));

            peopleByAge.add(p);
            peopleByName.add(p);
        }
        for (Person person : peopleByName) {
            System.out.println(person.getName()+" "+person.getAge());
        }
        for (Person person : peopleByAge) {
            System.out.println(person.getName()+" "+person.getAge());
        }
    }
}
