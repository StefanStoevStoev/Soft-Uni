package SortByNameAndAge1;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    Person(String firsName, String lastName, int age) {
        this.firstName = firsName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public int getAge(){
        return this.age;
    }

    @Override
    public String toString(){
        return String.format("%s %s is %d years old.",
                this.firstName, this.lastName, this.age);
    }
}
