package ValidationData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            try {
                people.add(PersonParser.personFrom(input));
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }

        double bonus = Double.parseDouble(reader.readLine());

        for (Person person : people) {
                person.increaseSalary(bonus);
                System.out.println(person);
        }
    }
}
