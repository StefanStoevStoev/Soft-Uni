package FirstAndReserveTeam;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    Person(String firsName, String lastName, int age, double salary) {
        this.setFirstName(firsName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public void increaseSalary(double bonus) {
        double baseBonus = this.getSalary() * bonus / 100;

        if (this.getAge() < 30) {
            this.setSalary(this.getSalary() + baseBonus / 2);
        } else {
            this.setSalary(this.getSalary() + baseBonus);
        }
    }

    public double getSalary() {
        return this.salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva",
                this.firstName, this.lastName, this.getSalary());
    }
}
