package L_1_CarShop;

public class Seat implements Car {
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    public Seat(String model, String color, Integer horsePower, String producer) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = producer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This is " + this.model + " produced in " + this.countryProduced + " and have " + TIRES + " tires");
    }
}
