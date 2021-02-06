package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<Person> listPerson = new ArrayList<>();

        while (!input.equals("END")) {

            String[] tokens = input.split("\\s+");
            listPerson.add(new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));

            input = scan.nextLine();
        }
        int number = Integer.parseInt(scan.nextLine());

        Person comparePerson = listPerson.get(number - 1);
        int count = 0;
        for (Person pp : listPerson) {
            if (pp.compareTo(comparePerson) == 0) {
                count++;
            }
        }

        if(count == 1){
            System.out.print("No matches");
        }else {
            System.out.printf("%d %d %d",count,listPerson.size()-count,listPerson.size());
        }

    }

}
