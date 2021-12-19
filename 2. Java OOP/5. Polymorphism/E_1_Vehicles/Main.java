package E_1_Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        Map<String, Vehicles> vehiclesMap = new LinkedHashMap<>();

        vehiclesMap.put("Car", new Car(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2])));

        tokens = scanner.nextLine().split("\\s+");

        vehiclesMap.put("Truck", new Truck(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2])));

        int comandCount = Integer.parseInt(scanner.nextLine());

        while (comandCount-- > 0){
            String command = scanner.nextLine();
            String[] params = command.split("\\s+");
            double argument = Double.parseDouble(params[2]);

            if (command.contains("Drive")){
                System.out.println(vehiclesMap.get(params[1]).drive(argument));
            } else {
                vehiclesMap.get(params[1]).refuel(argument);
            }
        }
        for (Vehicles value : vehiclesMap.values()) {
            System.out.println(value.toString());
        }
    }
}
