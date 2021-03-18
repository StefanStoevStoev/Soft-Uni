package E_1_Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicles {

    private double fuelQuantity;
    private double consumption;

    protected Vehicles(double fuelQuantity, double consumption) {
        this.fuelQuantity = fuelQuantity;
        this.consumption = consumption;
    }

    protected String drive(double distance) {
        double fuelNeed = distance * this.consumption;
        if (fuelNeed > this.fuelQuantity) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        this.fuelQuantity -= fuelNeed;
        DecimalFormat formatter = new DecimalFormat("##.##");

        return String.format("%s travelled %s km",
                this.getClass().getSimpleName(),
                formatter.format(distance));
    }

    protected void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(),this.fuelQuantity);
    }
}
