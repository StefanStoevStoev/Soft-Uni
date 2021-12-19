package E_ShoppingSpree;

public class Product {

    private String name;
    private double cost;

    public Product(String name, double cost) {
        this();
        this.setCost(cost);
        this.setName(name);
    }

    public Product() {
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name.trim();
    }

    private void setCost(double cost) {
        Validator.validateMoney(cost);
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }
}
