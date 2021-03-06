package StrategyPattern;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {/////////////////
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {///////////////
        return this.age;
    }

    @Override
    public int compareTo(Person other) {///////////////////
        int result = this.name.compareTo(other.name);
        if (result == 0) {
            result = this.age - other.age;
        }
        return result;
    }
}
