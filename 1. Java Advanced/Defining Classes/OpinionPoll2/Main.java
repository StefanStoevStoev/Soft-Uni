package OpinionPoll2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Person> listPersons = new ArrayList<>(n);

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            if (person.getName() != null) {
                listPersons.add(person);
            }
        }
        listPersons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
