package TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TrafficLight[] trafficLights = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(TrafficLight::valueOf)
                .toArray(TrafficLight[]::new);

        int n = Integer.parseInt(scan.nextLine());
        TrafficLight[] newLight = TrafficLight.values();

        while (n-- >0){
            for (int k = 0; k < trafficLights.length; k++) {
                TrafficLight light = trafficLights[k];
                int next = light.ordinal() + 1;

                trafficLights[k] = newLight[next % newLight.length];
                System.out.print(trafficLights[k] + " ");
            }
            System.out.println();
        }


    }
}
