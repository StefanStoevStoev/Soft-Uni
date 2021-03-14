package L_5_BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String token = reader.readLine();
        List<Identifiable> identifiables = new ArrayList<>();

        while (!token.equalsIgnoreCase("End")) {

            String[] input = token.split("\\s+");

            if (input.length == 3) {

                String name = input[0];
                int age = Integer.parseInt(input[1]);
                String id = input[2];
                identifiables.add(new Citizen(name,age,id));
            } else if (input.length == 2) {

                String model = input[0];
                String id = input[1];
                identifiables.add(new Robot(model,id));
            }

            token = reader.readLine();
        }
        String endSymbols = reader.readLine();

        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(endSymbols)){
                System.out.println(identifiable.getId());
            }
        }
    }
}
