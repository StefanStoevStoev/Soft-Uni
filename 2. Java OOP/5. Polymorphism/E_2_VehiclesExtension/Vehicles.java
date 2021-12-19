package E_2_VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicles {

    private double fuel;
    private double consumption;
    private double tank;

    protected Vehicles(double fuelQuantity, double consumption, int tank) {
        this.fuel = fuelQuantity;
        this.consumption = consumption;
        this.tank = tank;
    }


    protected String drive(double distance) {

        double fuelNeed = distance * this.consumption;
        if (fuelNeed > this.fuel) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        this.fuel -= fuelNeed;
        DecimalFormat formatter = new DecimalFormat("##.##");

        return String.format("%s travelled %s km",
                this.getClass().getSimpleName(),
                formatter.format(distance));
    }

    protected void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }
        double tankFuel = liters + this.fuel;
        if (tankFuel <= this.tank) {

            this.fuel += liters;
            return;
        }
        System.out.println("Cannot fit fuel in tank");
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuel);
    }
}
