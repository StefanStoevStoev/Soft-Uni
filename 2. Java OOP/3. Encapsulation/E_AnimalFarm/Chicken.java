package E_AnimalFarm;

public class Chicken {

    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {

        if (this.getAge() > -1 && this.getAge() < 6) {
            return 2;
        } else if (this.getAge() > 5 && this.getAge() < 12) {
            return 1;
        } else if (this.getAge() > 11 && this.getAge() < 16) {////////////////////
            return 0.75;
        }
        return 0.0;
    }

    private String getName() {
        return this.name;
    }

    private int getAge() {
        return this.age;
    }

    private void setName(String name) {
        if (name == null || name.length() < 1 || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                this.getName(),
                this.getAge(),
                this.productPerDay());
    }
}
