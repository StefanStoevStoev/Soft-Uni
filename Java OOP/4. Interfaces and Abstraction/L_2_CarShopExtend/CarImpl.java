package L_2_CarShopExtend;

public class CarImpl implements Car{

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    public CarImpl(String model, String color, Integer horsePower, String producer) {
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
        return "This is " + model + " produced in " + countryProduced + " and have " + TIRES + " tires";
    }
}
