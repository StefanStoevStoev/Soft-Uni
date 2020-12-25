package RawData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, Car> mapCar = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            double tire4Pressure = Double.parseDouble(tokens[11]);


            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire = new Tire(tire1Pressure, tire2Pressure, tire3Pressure, tire4Pressure);
            Car car = new Car(model, engine, cargo, tire);

            mapCar.put(model, car);
        }
        String cargoType = scan.nextLine();

        if ("fragile".equals(cargoType)) {
            mapCar.entrySet()
                    .stream()
                    .forEach(e -> {
                        if (e.getValue().getTires().getPressure() < 1 && e.getValue().getCargo().getCargoType().equals("fragile")) {
                            System.out.println(e.getKey());
                        }
                    });
        } else {
            mapCar.entrySet()
                    .stream()
                    .forEach(e -> {
                        if (e.getValue().getEngine().getEnginePower() > 250 && e.getValue().getCargo().getCargoType().equals("flamable")) {
                            System.out.println(e.getKey());
                        }
                    });
        }
    }
}
