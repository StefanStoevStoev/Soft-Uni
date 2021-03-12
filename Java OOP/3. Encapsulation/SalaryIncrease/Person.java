package SalaryIncrease;

public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;
    private double salary;

    Person(String firsName, String lastName, int age, double salary) {
        this.firstName = firsName;
        this.lastName = lastName;
        this.age = age;
        this.setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {

        double baseBonus = this.salary * bonus / 100;

        if (this.getAge() <= 30) {
            this.setSalary(this.getSalary() + baseBonus / 2);
        } else {
            this.setSalary(this.getSalary() + baseBonus);

        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getAge() {
        return this.age;
    }

    //Asen Ivanov gets 2640.0 leva
    @Override
    public String toString() {
        return String.format("%s %s gets %s leva",
                this.firstName, this.lastName, this.getSalary());
    }
//    private String removeTrailingZeros() {
//        return String.valueOf(this.salary).replaceAll("[0]*$", "").replaceAll("\\.", "");
//    }
}
