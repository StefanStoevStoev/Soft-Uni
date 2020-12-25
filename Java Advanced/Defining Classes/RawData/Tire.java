package RawData;

public class Tire {
    private double tire1Pressure;
    private double tire2Pressure;
    private double tire3Pressure;
    private double tire4Pressure;

    public Tire(double tire1Pressure, double tire2Pressure, double tire3Pressure, double tire4Pressure) {
        this.tire1Pressure = tire1Pressure;
        this.tire2Pressure = tire2Pressure;
        this.tire3Pressure = tire3Pressure;
        this.tire4Pressure = tire4Pressure;
    }

    public double getPressure(){
        double av = (tire1Pressure+tire2Pressure+tire3Pressure+tire4Pressure)/4;
        return av;
    }
}
