package ComparableBook;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){


        List<Book> arrList = new ArrayList<Book>(List.of(
                new Book("v",15,"George Orwell"),
                new Book("b",12),
                new Book("b",13),
                new Book("a",12),
                new Book("a",12)
        ));

        arrList.stream()
                .sorted()
                .peek(book -> System.out.println(book.toString()))
                .collect(Collectors.toList());
    }
}
