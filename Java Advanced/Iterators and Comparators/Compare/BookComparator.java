package Compare;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    private Book title;
    private Book year;

    public BookComparator(Book title, Book year) {
        this.title = title;
        this.year = year;
    }

    public int compare(Book first, Book second) {
        if (first.getTitle().compareTo(second.getTitle()) > 0) {
            return 1;
        } else if (first.getTitle().compareTo(second.getTitle()) < 0) {
            return -1;
        }
        if (first.getYear() > second.getYear()) {
            return 1;
        } else if (first.getYear() < second.getYear()) {
            return -1;
        }
        return 0;
    }
}
