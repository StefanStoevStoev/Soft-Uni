package OpinionPoll2;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        if (age > 30) {
            this.name = name;
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " - " + age;
    }
}
