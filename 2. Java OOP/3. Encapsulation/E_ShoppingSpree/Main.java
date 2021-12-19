package E_ShoppingSpree;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(";");
        Map<String, Person> peopleByNames = new LinkedHashMap<>();

        for (String ss : input) {
            String[] token = ss.split("=");
            String name = token[0];
            double money = Double.parseDouble(token[1]);
            Person p = new Person(name, money);
            peopleByNames.putIfAbsent(name, p);
        }

        String[] tokenProducts = scan.nextLine().split(";");
        Map<String, Product> productByNames = new HashMap<>();

        for (String ss : tokenProducts) {
            String[] inputProduct = ss.split("=");
            String product = inputProduct[0];
            double cost = Double.parseDouble(inputProduct[1]);
            Product p = new Product(product,cost);
            productByNames.putIfAbsent(product, p);
        }

        String line = scan.nextLine();

        while (!line.equals("END")){
            String[] token = line.split("\\s+");
            String name = token[0];
            String product = token[1];

            try {
                peopleByNames.get(name).buyProduct(productByNames.get(product));
                System.out.println(name + " bought " + product);
            } catch (IllegalStateException e){
                System.out.println(e.getMessage());
            }
            line = scan.nextLine();
        }

        for (Person value : peopleByNames.values()) {
            System.out.println(value.toString());
        }
    }
}
