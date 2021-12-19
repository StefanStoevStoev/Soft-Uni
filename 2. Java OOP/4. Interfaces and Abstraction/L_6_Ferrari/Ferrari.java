package L_6_Ferrari;

public class Ferrari implements Car{
    private String driverName;
    private String model = "488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return model + "/" + brakes() + "/" + gas() + "/" + driverName;
    }
}
