package SpeedRacing;

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
            int fuelAmount = Integer.parseInt(tokens[1]);
            double fuelCostFor1km = Double.parseDouble(tokens[2]);
            mapCar.put(model,new Car(model,fuelAmount,fuelCostFor1km));
        }
        String[] input = scan.nextLine().split("\\s+");
        while (!"End".equals(input[0])){
            String car = input[1];
            int distance = Integer.parseInt(input[2]);

            if(!mapCar.get(car).drive(distance)){
                System.out.println("Insufficient fuel for the drive");
            }

            input = scan.nextLine().split("\\s+");
        }
        for (Car value : mapCar.values()) {
            System.out.println(value);
        }
    }
}
