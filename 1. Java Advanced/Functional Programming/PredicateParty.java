import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> guests = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("Party!")) {
            String[] tokens = input.split("\\s+");
            Predicate<String> predicate = produsePredicate(tokens[1], tokens[2]);

            List<String> temp = new ArrayList<>();

            guests.forEach(n -> {
                if (predicate.test(n)) {
                    temp.add(n);
                }
            });
            if (tokens[0].equals("Remove")) {
                guests.removeAll(temp);
            } else {
                guests.addAll(temp);
            }

            input = scan.nextLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println((guests.stream()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.joining(", ")) + " are going to the party!"));
        }
    }

    private static Predicate<String> produsePredicate(String comand, String param) {
        Predicate<String> check;

        if (comand.equals("StartsWith")) {
            check = str -> str.startsWith(param);
        } else if (comand.equals("EndsWith")) {
            check = str -> str.endsWith(param);
        } else {
            check = str -> str.length() == Integer.parseInt(param);
        }
        return check;
    }
}
