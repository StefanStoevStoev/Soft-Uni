package E_2_VehiclesExtension;

public class Car extends Vehicles {
    private static final double AIR_CONDITIONER_CONSUMPTION = 0.9;


    protected Car(double fuelQuantity, double consumption, int tank) {
        super(fuelQuantity, consumption + AIR_CONDITIONER_CONSUMPTION, tank);
    }
}
