package SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double consumption;
    private int distance;


    public Car(String model, double fuelAmount, double consumption) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.consumption=consumption;
        this.distance = 0;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public boolean drive(int distance) {
        double fuelNeed = distance * consumption;
        if (fuelNeed <= this.fuelAmount) {
            this.distance += distance;
            this.fuelAmount -= fuelNeed;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);
    }
}
