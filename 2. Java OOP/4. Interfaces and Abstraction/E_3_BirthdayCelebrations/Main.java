package E_3_BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String token = reader.readLine();
        List<Birthable> birthables = new ArrayList<>();

        while (!token.equalsIgnoreCase("End")) {

            String[] input = token.split("\\s+");

            if (input[0].equalsIgnoreCase("Citizen")) {

                String name = input[1];
                int age = Integer.parseInt(input[2]);
                String id = input[3];
                String birthDate = input[4];
                birthables.add(new Citizen(name,age,id,birthDate));
            } else if (input[0].equalsIgnoreCase("Pet")){

                String model = input[1];
                String id = input[2];
                birthables.add(new Pet(model,id));
            }

            token = reader.readLine();
        }
        String birthDate = reader.readLine();
        boolean flag = true;
        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(birthDate)){
                flag = false;
                System.out.println(birthable.getBirthDate());
            }
        }
        if (flag){
            System.out.println("<no output>");
        }
    }


}
