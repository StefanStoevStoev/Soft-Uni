package E_2_VehiclesExtension;

public class Truck extends Vehicles {

    private static final double AIR_CONDITIONER_CONSUMPTION = 1.6;

    protected Truck(double fuelQuantity, double consumption, int tank) {
        super(fuelQuantity, consumption + AIR_CONDITIONER_CONSUMPTION, tank);
    }


    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
