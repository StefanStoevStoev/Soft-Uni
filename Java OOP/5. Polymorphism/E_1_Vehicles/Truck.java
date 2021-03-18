package E_1_Vehicles;

public class Truck extends Vehicles {

    private static final double AIR_CONDITIONER_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double consumption) {
        super(fuelQuantity, consumption + AIR_CONDITIONER_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
