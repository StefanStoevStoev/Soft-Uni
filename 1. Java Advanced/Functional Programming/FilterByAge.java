import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        readInput(new Scanner(System.in));
    }

    private static void readInput(Scanner scanner) {
        String numberOfPeople = scanner.nextLine().trim();
        int ppl = Integer.parseInt(numberOfPeople);
        List<Person> peopleList = new ArrayList<>();
        for (int k = 0; k < ppl; k++) {
            String personLine = scanner.nextLine();
            String[] split = personLine.split(", ");
            Person person = new Person(split[0], Integer.parseInt(split[1].trim()));
            peopleList.add(person);
        }
        String condition = scanner.nextLine().trim();
        int conditionAge = Integer.parseInt(scanner.nextLine().trim());
        Predicate<Person> personPredicate = getPersonPredicate(condition, conditionAge);
        
        String printCondition = scanner.nextLine().trim();
        Consumer<Person> personPrinter = getPersonPrinter(printCondition);

        for (Person p : peopleList) {
            if(personPredicate.test(p)){
                personPrinter.accept(p);
            }
        }
    }

    private static Consumer<Person> getPersonPrinter(String printCondition) {
        switch (printCondition){
            case "age":
                return (person -> System.out.println(person.getAge()));
            case "name":
                return (person -> System.out.println(person.getName()));
            default:
                return (person -> System.out.println(
                        person.getName() + " - " + person.getAge()));
        }
    }

    private static Predicate<Person> getPersonPredicate(String condition, int conditionAge) {
        Predicate<Person> personPredicate;
        if ("younger".equals(condition)) {
            personPredicate = person -> person.getAge() <= conditionAge;
        } else {
            personPredicate = person -> person.getAge() >= conditionAge;
        }
        return personPredicate;
    }

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.age = age;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
