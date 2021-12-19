package E_2_VehiclesExtension;

public class Bus extends Vehicles {
    private static final double AIR_CONDITIONER_CONSUMPTION = 1.4;


    protected Bus(double fuelQuantity, double consumption, int tank) {
        super(fuelQuantity, consumption + AIR_CONDITIONER_CONSUMPTION, tank);
    }
}
