package Compare;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("A", 1, "George Orwell");
        Book bookThree = new Book("B", 3);
        Book bookTwo = new Book("A", 3, "Dorothy Sayers", "Robert Eustace");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        books.sort(new BookComparator(books.get(0),books.get(1)));

        for (Book book : books) {
            System.out.println(book.getTitle() + book.getYear());
        }
    }
}
