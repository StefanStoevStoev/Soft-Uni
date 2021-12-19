package L_2_CarShopExtend;

public class Audi extends CarImpl implements Rentable {

    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String producer,Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, producer);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }
    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + "Minimum rental period of " + this.minRentDay + " days. Price per day " + this.pricePerDay;
    }
}
