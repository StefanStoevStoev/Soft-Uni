package L_2_CarShopExtend;

public class Seat extends CarImpl implements Sellable {

    private Double getPrice;

    public Seat(String model, String color, Integer horsePower, String producer, Double getPrice) {
        super(model,color,horsePower,producer);
        this.getPrice = getPrice;
    }

    @Override
    public Double getPrice() {
        return this.getPrice;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + this.getModel() + " sells for " + this.getPrice;
    }

}
