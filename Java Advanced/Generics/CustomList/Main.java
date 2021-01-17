package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        CustomList<String> listElements = new CustomList<String>();

        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {///
                case "Add":
                    listElements.add(tokens[1]);
                    break;
                case "Max"://///////////
                    System.out.println(listElements.getMax());
                    break;
                case "Min"://////////////
                    System.out.println(listElements.getMin());
                    break;
                case "Remove":///////////
                    listElements.remove2(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":///////////
                    System.out.println(listElements.contains(tokens[1]));
                    break;
                case "Swap":
                    listElements.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(listElements.countGreaterThan(tokens[1]));
                    break;
                case "Print"://///////////
                    listElements.print();
                    break;
                case "Sort"://///////////
                    listElements.sort();
                    break;
            }
            input = scan.nextLine();
        }
        for (String listElement : listElements) {
            System.out.println(listElement);
        }
    }
}
