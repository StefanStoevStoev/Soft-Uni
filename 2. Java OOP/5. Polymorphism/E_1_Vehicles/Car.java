package E_1_Vehicles;

public class Car extends Vehicles{
    private static final double AIR_CONDITIONER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double consumption) {
        super(fuelQuantity, consumption + AIR_CONDITIONER_CONSUMPTION);
    }

}
