package bakery.entities.tables.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static bakery.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseTable implements Table {

    protected Collection<BakedFood> foodOrders;
    protected Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private double price;
    private boolean isReserved;


    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        this.price = 0;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setReserved(boolean reserved) {
        this.isReserved = reserved;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
        this.price = numberOfPeople * this.getPricePerPerson();
        this.isReserved = true;
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double priceAllDrinks = this.drinkOrders.stream().mapToDouble(Drink::getPrice).sum();
        double priceAllFood = this.foodOrders.stream().mapToDouble(BakedFood::getPrice).sum();
        return priceAllDrinks + priceAllFood + this.getPrice();
    }

    @Override
    public void clear() {
        this.foodOrders.clear();
        this.drinkOrders.clear();
        this.setReserved(false);
        this.numberOfPeople = 0;
        this.price = 0;
    }

    @Override
    public String getFreeTableInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Table: %d",this.tableNumber)).append(System.lineSeparator());
        sb.append(String.format("Type: %s",this.getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("Capacity: %s",this.capacity)).append(System.lineSeparator());
        sb.append(String.format("Price per Person: %.2f",this.pricePerPerson));
        return sb.toString();
    }
}
